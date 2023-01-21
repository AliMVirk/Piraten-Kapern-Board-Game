package pk;

public class Game {

    public Player p1 = new Player();
    public Player p2 = new Player();

    public void turn(Player p) {
        int keepDice = 0;
        p.resetDice();
        while (p.countSkulls() < 3 && keepDice < 7)
            keepDice = p.rollRemaining(keepDice);
        if (p.countSkulls() < 3)
            p.updatePoints();
    }

    public void playGame() {
        while (true) {
            turn(p1);
            turn(p2);
            if (p1.totalPoints >= 6000 || p2.totalPoints >= 6000) {
                if (p1.totalPoints > p2.totalPoints)
                    p1.totalWins++;
                else if (p2.totalPoints > p1.totalPoints)
                    p2.totalWins++;
                p1.resetPoints(); p2.resetPoints();
                break;
            }
        }
    }

}
