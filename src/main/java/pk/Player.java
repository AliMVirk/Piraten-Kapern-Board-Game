package pk;
import java.util.Arrays;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Player {

    public Dice[] diceSet = new Dice[8];
    public Faces[] rollResult = new Faces[8];
    public int totalPoints = 0;
    public int totalWins = 0;
    private static final Logger logger = LogManager.getLogger(Player.class); // to debug

    public Player() {
        for (int i = 0; i < 8; i++)
            diceSet[i] = new Dice();
    }

    public int rollRemaining(int diceKept) {
        Random bag = new Random();
        int keepDice = (diceKept == 8) ? 0 : bag.nextInt(8 - diceKept);
        keepDice += diceKept;
        int i, j; i = j = 0; // i represents counter over dice set and j represents counter over dice to keep
        for (Dice die : diceSet) {
            if (rollResult[i] != Faces.SKULL) {
                if (j >= keepDice || rollResult[i] == null)
                    rollResult[i] = die.roll();
                j++;
            }
            i++;
        }
        if (j <= keepDice)
            return 8;
        else
            return keepDice;
    }

    public int countSkulls() {
        int numSkulls = 0;
        for (Faces dieResult : rollResult) {
            if (dieResult == Faces.SKULL)
                numSkulls++;
        }
        return numSkulls;
    }

    public void updatePoints() {
        int[] faceCounter = new int[] {0, 0, 0, 0, 0};
        for (Faces dieResult : rollResult) {
            if (dieResult == Faces.GOLD || dieResult == Faces.DIAMOND)
                totalPoints += 100;
            for (int i = 0; i < 5; i++) {
                if (dieResult == Faces.values()[i])
                    faceCounter[i]++;
            }
        }
        for (int group : faceCounter) {
            if (group == 8)
                totalPoints += 4000;
            else if (group == 7)
                totalPoints += 2000;
            else if (group == 6)
                totalPoints += 1000;
            else if (group == 5)
                totalPoints += 500;
            else if (group == 4)
                totalPoints += 200;
            else if (group == 3)
                totalPoints += 100;
        }
    }

    public void resetDice() {
        for (int i = 0; i < 8; i++)
            rollResult[i] = null;
    }
    
}
