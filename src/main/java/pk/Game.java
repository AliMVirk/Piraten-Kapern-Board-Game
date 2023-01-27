package pk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class Game {

    public static final Logger logger = LogManager.getLogger(Game.class);
    public Player p1;
    public Player p2;
    public boolean trace = false;

    public Game(String p1Strat, String p2Strat) {
        p1 = new Player(p1Strat);
        p2 = new Player(p2Strat);
    }

    public void turn(Player p) {
        boolean keepRolling = true;
        p.resetDice();
        while (p.countSkulls() < 3 && keepRolling) {
            if (p.strategy.equals("random"))
                keepRolling = p.rollRandom();
            else if (p.strategy.equals("combo"))
                keepRolling = p.rollCombo();
            else
                System.exit(1);
            if (trace)
                logger.trace(Arrays.toString(p.rollResult));
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