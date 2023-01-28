package pk;
import java.util.ArrayList;

public class Player {

    public Dice[] diceSet = new Dice[8];
    public Faces[] rollResult = new Faces[8];
    public int totalPoints = 0;
    public int totalWins = 0;
    public String strategy;
    public String playerCard;

    public Player(String ai) {
        for (int i = 0; i < 8; i++)
            diceSet[i] = new Dice();
        strategy = ai;
    }

    public boolean rollRandom() {
        int diceToKeep = (int) (Math.random() * 8) + 1 - countSkulls();
        ArrayList<Integer> diceToRoll = new ArrayList<Integer>();
        for (int i = 0; i < 8; i++) {
            if (rollResult[i] != Faces.SKULL) {
                if (diceToKeep == 0 || rollResult[i] == null)
                    diceToRoll.add(i);
                else
                    diceToKeep--;
            }
        }
        if (diceToRoll.size() == 0 || diceToRoll.size() == 1)
            return false;
        rollDice(diceToRoll);
        return true;
    }

    public boolean rollCombo() {
        Faces priority = findMaxFace();
        ArrayList<Integer> diceToRoll = new ArrayList<Integer>();
        for (int i = 0; i < 8; i++) {
            if (rollResult[i] != Faces.SKULL && rollResult[i] != priority && countSkulls() < 2 || rollResult[i] == null)
                diceToRoll.add(i);
        }
        if (diceToRoll.size() == 0 || diceToRoll.size() == 1)
            return false;
        rollDice(diceToRoll);
        return true;
    }

    public void rollDice(ArrayList<Integer> diceToRoll) {
        for (int pos : diceToRoll) {
            rollResult[pos] = diceSet[pos].roll();
        }
    }

    public boolean seaBattle() {
        ArrayList<Integer> diceToRoll = new ArrayList<Integer>();
        int numSabers = countFaces()[4];
        int minSabers = Character.getNumericValue(playerCard.charAt(2));
        for (int i = 0; i < 8; i++) {
            if (rollResult[i] != Faces.SKULL && rollResult[i] != Faces.SABER)
                diceToRoll.add(i);
        }
        if (diceToRoll.size() == 0 || diceToRoll.size() == 1 || numSabers >= minSabers)
            return false;
        rollDice(diceToRoll);
        return true;
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

    public void resetDice() {
        for (int i = 0; i < 8; i++)
            rollResult[i] = null;
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

    public boolean seaBattleResult() {
        int numSabers = countFaces()[4];
        int minSabers = Character.getNumericValue(playerCard.charAt(2));
        if (numSabers >= minSabers && countSkulls() < 3) {
            switch (minSabers) {
                case 4:
                    totalPoints += 1000;
                    break;
                case 3:
                    totalPoints += 500;
                    break;
                case 2:
                    totalPoints += 300;
                    break;
            }
            return true;
        } else {
            switch (minSabers) {
                case 4:
                    totalPoints -= 1000;
                    break;
                case 3:
                    totalPoints -= 500;
                    break;
                case 2:
                    totalPoints -= 300;
                    break;
            }
            if (totalPoints < 0)
                totalPoints = 0;
            return false;
        }
    }
    
}
