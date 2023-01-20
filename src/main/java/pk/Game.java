package pk;

public class Game {

    public Player p1 = new Player();
    public Player p2 = new Player();

    public void turn(Player p) {
        int keepDice = 0;
        while (p.countSkulls() < 3 && keepDice < 7) {
            keepDice = p.rollRemaining(keepDice);

            System.out.println(keepDice);
            for (int j = 0; j < 8; j++)
                System.out.print(p.rollResult[j] + " ");   //print roll results
            System.out.println();
        }
        if (p.countSkulls() < 3)
            p.updatePoints();
        System.out.println(p.totalPoints);
    }

    public void playGame() {
        turn(p1);
        System.out.println("NEXT PLAYER");
        turn(p2);
    }


}
