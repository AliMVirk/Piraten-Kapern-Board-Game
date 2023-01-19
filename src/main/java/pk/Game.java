package pk;

public class Game {

    public Player p1 = new Player();
    public Player p2 = new Player();

    public Game() {
        while (true) {
            p1.rollRemaining();
        }
    }
}
