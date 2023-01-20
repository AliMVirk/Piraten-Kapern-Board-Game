package pk;
import java.util.Random;

public class Player {

    public Dice[] diceSet = new Dice[8];
    public Faces[] rollResult = new Faces[8];
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
            if (rollResult[i] != Faces.SKULL && (j >= keepDice || rollResult[i] == null))
                rollResult[i] = die.roll();
            i++; j++;
        }
        return keepDice;
    }

    public int countSkulls() {
        int numSkulls = 0;
        for (Faces die : rollResult) {
            if (die == Faces.SKULL)
                numSkulls++;
        }
        return numSkulls;
    }

}
