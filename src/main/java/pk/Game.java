package pk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class Game {

    private static final Logger logger = LogManager.getLogger(Game.class);
    public Player p1 = new Player();
    public Player p2 = new Player();
    public boolean trace = false;

    public void turn(Player p) {
        int keepDice = 0;
        p.resetDice();
        while (p.countSkulls() < 3 && keepDice < 7) {
            keepDice = p.rollRemaining(keepDice);
            if (trace) {
                logger.trace("Player kept " + keepDice + " dice"); // irrelevant on very first roll
                logger.trace(Arrays.toString(p.rollResult));
            }
        }
        if (p.countSkulls() < 3)
            p.updatePoints();
    }

    public void playGame() {
        while (true) {
            if (trace)
                logger.trace("NEW TURN: Player 1");
            turn(p1);
            if (trace) {
                logger.trace("Player 1 has " + p1.totalPoints + " points");
                logger.trace("NEW TURN: Player 2");
            }
            turn(p2);
            if (trace)
                logger.trace("Player 2 has " + p2.totalPoints + " points");
            if (p1.totalPoints >= 6000 || p2.totalPoints >= 6000) {
                if (p1.totalPoints > p2.totalPoints)
                    p1.totalWins++;
                else if (p2.totalPoints > p1.totalPoints)
                    p2.totalWins++;
                p1.totalPoints = p2.totalPoints = 0;
                break;
            }
        }
    }

}
