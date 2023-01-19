package pk;

public class Game {

    public Player p1 = new Player();
    public Player p2 = new Player();

    public void playGame() {
        while (true) {
            while (p1.countSkulls() < 3) {
                p1.rollRemaining();

                /*for (int i = 0; i < 8; i++)
                    System.out.print(p1.rollResult[i] + " ");   print roll results
                System.out.println();*/
            }
            while (p2.countSkulls() < 3) {
                p2.rollRemaining();

                /*for (int i = 0; i < 8; i++)
                    System.out.print(p2.rollResult[i] + " ");   print roll results
                System.out.println();*/
            }
        }
    }


}
