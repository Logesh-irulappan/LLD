import java.util.ArrayList;
import java.util.Collections;

public class GameBoard {

    private final static int n = 3;
    private int[][] board = new int[n][n];
    private int emptyX, emptyY;

    public void fillBoard() {

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i < n*n; i++)
            list.add(i);
        list.add(0);
        Collections.shuffle(list);

        emptyX = list.indexOf(0) / n;
        emptyY = list.indexOf(0) % n;

        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = list.get(temp);
                temp++;
            }
        }

    }

    public void displayBoard() {
        for(int i = 0; i < n; i++) {
            System.out.print("| ");
            for(int j = 0; j < n; j++) {
                if(board[i][j] < 10)
                    System.out.print(" " + board[i][j] +" |");
                else
                    System.out.print(board[i][j] + " |");
            }
            System.out.println();
        }
    }

    public void changePosition(int userMove) throws Exception {
        switch (userMove) {
            case 1: {
                // Above
                if(IsPositionValid(emptyX - 1, emptyY)) {
                    board[emptyX][emptyY] = board[emptyX - 1][emptyY];
                    board[emptyX - 1][emptyY] = 0;
                    this.emptyX -= 1;
                }
                else
                    throw new ExceptionThrow("Invalid Move");
                break;
            }
            case 2: {
                // Below
                if(IsPositionValid(emptyX + 1, emptyY)) {
                    board[emptyX][emptyY] = board[emptyX + 1][emptyY];
                    board[emptyX + 1][emptyY] = 0;
                    this.emptyX += 1;
                }
                else
                    throw new ExceptionThrow("Invalid Move");

                break;
            }
            case 3: {
                // Right
                if(IsPositionValid(emptyX, emptyY + 1)) {
                    board[emptyX][emptyY] = board[emptyX][emptyY + 1];
                    board[emptyX][emptyY + 1] = 0;
                    this.emptyY += 1;
                }
                else
                    throw new ExceptionThrow("Invalid Move");
                break;
            }
            case 4: {
                // Left
                if(IsPositionValid(emptyX, emptyY - 1)) {
                    board[emptyX][emptyY] = board[emptyX][emptyY - 1];
                    board[emptyX][emptyY - 1] = 0;
                    this.emptyY -= 1;
                }
                else
                    throw new ExceptionThrow("Invalid Move");
                break;
            }
        }
    }

    public static boolean IsPositionValid(int x, int y) {
        return (x >= 0) && (x <= n - 1) && (y >= 0) && (y <= n - 1);
    }

    public boolean checkForWin() {
        if(board[n-1][n-1] == 0) {
            int temp = 1;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(board[i][j] != temp && i != board[n-1][n-1])
                        return false;
                    temp++;
                }
            }
            return true;
        }
        else
            return false;
    }

}
