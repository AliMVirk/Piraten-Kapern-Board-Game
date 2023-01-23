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

    public int[] countFaces() {
        int[] faceCounter = new int[] {0, 0, 0, 0, 0};
        for (Faces dieResult : rollResult) {
            for (int i = 0; i < 5; i++) {
                if (dieResult == Faces.values()[i])
                    faceCounter[i]++;
            }
        }
        return faceCounter;
    }

    public void updatePoints() {
        int[] numFaces = countFaces();
        totalPoints += (numFaces[2] + numFaces[3]) * 100;
        for (int group : numFaces) {
            switch (group) {
                case 8:
                    totalPoints += 4000;
                case 7:
                    totalPoints += 2000;
                case 6:
                    totalPoints += 1000;
                case 5:
                    totalPoints += 500;
                case 4:
                    totalPoints += 200;
                case 3:
                    totalPoints += 100;
            }
        }
        logger.trace("(DEBUG) " + Arrays.toString(numFaces));
    }

    public void resetDice() {
        for (int i = 0; i < 8; i++)
            rollResult[i] = null;
    }
    
}
