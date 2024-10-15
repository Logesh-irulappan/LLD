import java.util.Scanner;

public class Game {

    private final GameBoard gb;
    private final int gameID;
    private final Player player;

    public Game(String playerName) {
         this.gb = new GameBoard();
         this.gameID = gb.hashCode();
         this.player = new Player(playerName, gameID);
    }

    public int getGameID() {
        return gameID;
    }

    public void startGame() {
        gb.fillBoard();
        gb.displayBoard();
        gameLogic();
    }

    private void gameLogic() {
        int userMove = -1;
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("\n 1. ABOVE \n 2. BELOW \n 3. RIGHT \n 4. LEFT \n 5. Quit \n Enter your Option: ");
            try {
                userMove = in.nextInt();
                if(userMove > 5 || userMove < 0 )
                    throw new ExceptionThrow("Invalid Option");
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
                gameLogic();
                break;
            }

            try {
                gb.changePosition(userMove);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                gameLogic();
                break;
            }
            gb.displayBoard();

            if(gb.checkForWin()) {
                System.out.println("YOU WON");
                break;
            }

        } while(userMove != 5);
    }

}
