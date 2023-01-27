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

    public Card[] cards = new Card[35];
    int top = 0;
    
    public Deck() {
        cards[0] = new Card("SB2");
        cards[1] = new Card("SB2");
        cards[2] = new Card("SB3");
        cards[3] = new Card("SB3");
        cards[4] = new Card("SB4");
        cards[5] = new Card("SB4");
    }

    public Card draw() {
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
            Card temp = cards[randomPos];
            cards[randomPos] = cards[i];
            cards[i] = temp;
        }
    }

}
