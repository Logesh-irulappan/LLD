import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String player_name = in.nextLine();

        Game player1 = new Game(player_name);

        boolean gameStatus = true;
        do {
            System.out.print(" 1. START \n 2. QUIT \n");
            System.out.print("Enter your choice: ");
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    player1.startGame();
                    break;
                case 2:
                    gameStatus = false;
                    break;
            }

        } while(gameStatus);

        System.out.println(" THANK YOU!..");
    }
}