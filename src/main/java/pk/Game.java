package pk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class Game {

    private static final Logger logger = LogManager.getLogger(Game.class);
    public Player p1;
    public Player p2;
    public boolean trace = false;

    public Game(String p1Strat, String p2Strat) {
        p1 = new Player(p1Strat);
        p2 = new Player(p2Strat);
    }

    public void turn(Player p) {
        int keepDice = 0;
        p.resetDice();
        while (p.countSkulls() < 3 && keepDice < 8) {
            if (p.strategy.equals("random")) {
                keepDice = p.rollRemaining(keepDice);
                if (trace) {
                    logger.trace("Player kept " + keepDice + " dice excluding skulls"); // irrelevant on very first roll
                    logger.trace(Arrays.toString(p.rollResult));
                }
            } else if (p.strategy.equals("combo")) {
                keepDice = p.rollCombo() + p.countSkulls();
                if (trace) {
                    logger.trace("Player kept " + (keepDice - p.countSkulls()) + " dice excluding skulls");
                    logger.trace(Arrays.toString(p.rollResult));
                }
            } else
                System.exit(1);
        }
        if (p.countSkulls() < 3)
            p.updatePoints();
    }

    public void playGame() {
        while (true) {
            if (trace)
                logger.trace("NEW TURN: Player 1");
            turn(p1);
            if (trace)
                logger.trace("Player 1 has " + p1.totalPoints + " points");
            if (p2.totalPoints >= 6000)
                break;
            if (trace)
                logger.trace("NEW TURN: Player 2");
            turn(p2);
            if (trace)
                logger.trace("Player 2 has " + p2.totalPoints + " points");
            if (p1.totalPoints >= 6000)
                break;
            }
        if (p1.totalPoints > p2.totalPoints)
            p1.totalWins++;
        else if (p2.totalPoints > p1.totalPoints)
            p2.totalWins++;
        p1.totalPoints = p2.totalPoints = 0;
        }
}