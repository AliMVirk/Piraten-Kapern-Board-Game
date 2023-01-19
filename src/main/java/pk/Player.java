package pk;

public class Player {

    public Dice[] diceSet = new Dice[8];
    public Faces[] rollResult = new Faces[8];
    public Player() {
        for (int i = 0; i < 8; i++)
            diceSet[i] = new Dice();
    }

    public void rollRemaining() {
        int i = 0;
        for (Dice die : diceSet) {
            if (rollResult[i] != Faces.SKULL)
                rollResult[i] = die.roll();
            i++;
        }
    }

}
