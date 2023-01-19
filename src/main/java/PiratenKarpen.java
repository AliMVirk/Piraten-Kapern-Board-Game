import pk.Dice;
import pk.Faces;
import pk.Player;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");

        Player p1 = new Player();
        for (int j = 0; j < 4; j++) {
            p1.rollRemaining();
            for (int i = 0; i < 8; i++)
                System.out.print(p1.rollResult[i] + " ");
            System.out.println();
        }

        System.out.println("That's all folks!");
    }
    
}
