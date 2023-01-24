import pk.*;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");

        Game play42;
        try {
            play42 = new Game(args[0], args[1]);
        } catch (Exception IndexOutOfBoundsException) {
            return;
        }

        if (args.length > 0 && args[args.length - 1].equals("log"))
            play42.trace = true;
        for (int i = 0; i < 42; i++)
            play42.playGame();
        System.out.printf("Player 1 win percentage: %.2f\n", play42.p1.totalWins/42.0);
        System.out.printf("Player 2 win percentage: %.2f\n", play42.p2.totalWins/42.0);

        System.out.println("That's all folks!");
    }
    
}
