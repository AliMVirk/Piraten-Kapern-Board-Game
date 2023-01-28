package pk;
import java.util.Random;

/*
 * SB2 = Sea Battle for 2
 * SB3 = Sea Battle for 3
 * SB4 = Sea Battle for 4
 * MB = Monkey Business
 * DI = Diamond
 * TC = Treasure Chest
 * SO = Sorceress
 * PC = Pirate Captain
 * GO = Gold
 * SK1 = Skull 1
 * SK2 = Skull 2
 */

public class Deck {

    public String[] cards = new String[35];
    int top = 35;
    
    public Deck() {
        cards[0] = "SB2";
        cards[1] = "SB2";
        cards[2] = "SB3";
        cards[3] = "SB3";
        cards[4] = "SB4";
        cards[5] = "SB4";
        for (int i = 6; i < 35; i++)
            cards[i] = "nop";
    }

    public String draw() {
        if (top == 35) {
            top = 0;
            shuffle();
        }
        top++;
        return cards[top - 1];
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < 35; i++) {
            int randomPos = rand.nextInt(35);
            String temp = cards[randomPos];
            cards[randomPos] = cards[i];
            cards[i] = temp;
        }
    }

}
