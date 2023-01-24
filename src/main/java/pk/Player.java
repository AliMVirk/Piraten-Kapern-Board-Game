package pk;
import java.util.Random;

public class Player {

    public Dice[] diceSet = new Dice[8];
    public Faces[] rollResult = new Faces[8];
    public int totalPoints = 0;
    public int totalWins = 0;
    public String strategy;

    public Player(String ai) {
        for (int i = 0; i < 8; i++)
            diceSet[i] = new Dice();
        strategy = ai;
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

    public int rollCombo() {
        Faces priority = findMaxFace();
        int keepDice = 0;
        for (int i = 0; i < 8; i++) {
            if (rollResult[i] != Faces.SKULL) {
                if (rollResult[i] != priority && countSkulls() < 2 || rollResult[i] == null)
                    rollResult[i] = diceSet[i].roll();
                else
                    keepDice++;
            }
        }
        return keepDice;
    }

    public Faces findMaxFace() {
        int[] numFaces = countFaces();
        int max = 0; Faces maxFace = null;
        for (int i = 0; i < 5; i++) {
            if (numFaces[i] > max) {
                max = numFaces[i];
                maxFace = Faces.values()[i];
            }
        }
        return maxFace;
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
                    break;
                case 7:
                    totalPoints += 2000;
                    break;
                case 6:
                    totalPoints += 1000;
                    break;
                case 5:
                    totalPoints += 500;
                    break;
                case 4:
                    totalPoints += 200;
                    break;
                case 3:
                    totalPoints += 100;
                    break;
            }
        }
    }

    public void resetDice() {
        for (int i = 0; i < 8; i++)
            rollResult[i] = null;
    }
    
}
