/**
 * This file contains the logic for playing a connect four game
 * either against another player or a random agent, depending on
 * the given command line args.
 *
 * I worked on the homework assignment alone, using only course materials.
 *
 * @author Jared Duncan
 * @author Julia Ting
 */

import java.util.Scanner;
import java.util.Random;

public class ConnectFour {

    /*
     * Static variables to use throughout printBoard()
     * and the main method. You MUST use "X" and "O",
     * so you might as well use TOKEN1 and TOKEN2 variables!
     */
    private static final int GAME_WIDTH = 7;
    private static final int GAME_HEIGHT = 6;
    private static final String TOKEN1 = "X";
    private static final String TOKEN2 = "O";

    /**
     * Alter this variable when making changes to your
     * connect four board!!
     */
    private static String[][] board = new String[GAME_HEIGHT][GAME_WIDTH];

    /**
     * This enumeration is used as outcomes for findWinner().
     *
     * Read the pdf for a complete description. Think of how
     * GameStatus.QUIT might help you in your game functionality!
     */
    private enum GameStatus {
        ONE, TWO, TIE, ONGOING, QUIT
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String players;

        if (args.length == 0) {
            System.out.println("Would you like to play single player or"
                + " two player mode? (Enter 1 or 2)");
            players = input.nextLine();
        } else {
            players = args[0];
        }

        boolean singlePlayer = players.equals("1");
        boolean playerOnesTurn = true;
        GameStatus status = GameStatus.ONGOING;
        boolean[] columnIsFull = new boolean[7];

        System.out.println("\nWelcome to the " + players
            + " player mode of Connect Four!");

        while (status == GameStatus.ONGOING) {
            for (int i = 0; i < columnIsFull.length; i++) {
                columnIsFull[i] = board[0][i] != null;
            }

            String currentToken;
            if (playerOnesTurn) {
                currentToken = TOKEN1;
            } else {
                currentToken = TOKEN2;
            }

            System.out.println("Choose where to go by"
                + " entering the slot number.");
            System.out.println("Type 'q' if you would like to quit.");
            printBoard();

            int index = 0;
            do {
                if (playerOnesTurn) {
                    System.out.println("Player 1, where would you like to go?");
                } else {
                    System.out.println("Player 2, where would you like to go?");
                }

                String selection = input.nextLine();
                if (selection.equals("q")) {
                    status = GameStatus.QUIT;
                    break;
                }

                index = Integer.parseInt(selection) - 1;

                if (columnIsFull[index]) {
                    System.out.println("That column is full."
                        + " Please pick another!");
                }
            } while (columnIsFull[index]);

            if (status == GameStatus.QUIT) {
                break;
            }

            placeToken(index, currentToken);

            status = findWinner();

            if (singlePlayer && status == GameStatus.ONGOING) {
                printBoard();
                Random rand = new Random();

                int columnSelection;
                do {
                    columnSelection = rand.nextInt(7);
                } while (columnIsFull[columnSelection]);

                placeToken(columnSelection, TOKEN2);
                System.out.println("Player 2 chose column "
                    + (columnSelection + 1));
                status = findWinner();
            } else {
                playerOnesTurn = !playerOnesTurn;
            }
        }

        printBoard();

        switch (status) {
        case QUIT:
            System.out.println("Goodbye!");
            break;
        case ONE:
            System.out.println("Woohoo! Player 1 won!");
            break;
        case TWO:
            System.out.println("Woohoo! Player 2 won!");
            break;
        case TIE:
            System.out.println("There was a tie!");
            break;
        default:
        }
    }

    /**
     * Prints the current state of the board array.
     *
     * @return void
     **/
    private static void printBoard() {
        for (int r = 0; r < GAME_HEIGHT; r++) {
            int ind = -1;
            for (int c = 0; c <= GAME_WIDTH * 4; c++) {
                if (c % 4 == 0) {
                    System.out.print("|");
                    ind++;
                } else if (c % 4 == 2 && board[r][ind] != null
                    && !board[r][ind].isEmpty()) {
                    System.out.print(board[r][ind]);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for (int i = 0; i <= GAME_WIDTH * 4; i++) {
            System.out.print("-");
        }
        System.out.println();

        int counter = 1;
        for (int i = 0; i <= GAME_WIDTH * 4; i++) {
            if (i % 4 == 2) {
                System.out.print(counter);
                counter++;
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    /**
     * Places token on the board.
     *
     * @return void
     **/
    private static void placeToken(int index, String token) {
        boolean isPlaced = false;
        for (int i = 1; !isPlaced; i++) {
            if (i >= GAME_HEIGHT) {
                board[GAME_HEIGHT - 1][index] = token;
                isPlaced = true;
            } else if (board[i][index] != null && !board[i][index].isEmpty()) {
                board[i - 1][index] = token;
                isPlaced = true;
            }
        }
    }

    /**
     * Determines what the current result of the game is
     * given the current state of the board.
     *
     * @return GameStatus enumeration value that determines
     * if player one has won, player two has won, a tie exists,
     * or there is no result yet.
     */
    private static GameStatus findWinner() {
        if (isColumnVictory(TOKEN1) || isRowVictory(TOKEN1)
                || isTopLeftDiagonalVictory(TOKEN1)
                || isTopRightDiagonalVictory(TOKEN1)) {
            return GameStatus.ONE;
        } else if (isColumnVictory(TOKEN2) || isRowVictory(TOKEN2)
                || isTopLeftDiagonalVictory(TOKEN2)
                || isTopRightDiagonalVictory(TOKEN2)) {
            return GameStatus.TWO;
        } else if (isBoardFull()) {
            return GameStatus.TIE;
        } else {
            return GameStatus.ONGOING;
        }
    }

    /*
     * ~~~~~~YOU SHOULD NOT BE CALLING METHODS BELOW THIS POINT~~~~~
     */

    /**
     * Determines whether or not the board has any moves
     * remaining.
     *
     * @return true or false
     */
    private static boolean isBoardFull() {
        for (int col = 0; col < GAME_WIDTH; col++) {
            for (int row = 0; row < GAME_HEIGHT; row++) {
                if (board[row][col] == null || board[row][col].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Determines whether or not a player has won via 4 in a row
     * in columns.
     *
     * @return true or false
     */
    private static boolean isColumnVictory(String token) {
        for (int col = 0; col < GAME_WIDTH; col++) {
            int count = 0;
            for (int row = 0; row < GAME_HEIGHT; row++) {
                if (board[row][col] != null) {
                    if (board[row][col].equals(token)) {
                        count++;
                    } else {
                        count = 0;
                    }
                } else {
                    count = 0;
                }
                if (count == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Determines whether or not a player has won via 4 in a row
     * in rows.
     *
     * @return true or false
     */
    private static boolean isRowVictory(String token) {
        for (int row = 0; row < GAME_HEIGHT; row++) {
            int count = 0;
            for (int col = 0; col < GAME_WIDTH; col++) {
                if (board[row][col] != null) {
                    if (board[row][col].equals(token)) {
                        count++;
                    } else {
                        count = 0;
                    }
                } else {
                    count = 0;
                }
                if (count == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Determines whether or not a player has won via 4 in a row
     * in top to left diagonals.
     *
     * @return true or false
     */
    private static boolean isTopLeftDiagonalVictory(String token) {
        for (int row = 0; row < GAME_HEIGHT; row++) {
            for (int col = 0; col < GAME_WIDTH; col++) {
                int count = 0;
                for (int delta = 0; delta < 5; delta++) {
                    if (withinBounds(row + delta, col + delta)
                            && board[row + delta][col + delta] != null) {
                        if (board[row + delta][col + delta].equals(token)) {
                            count++;
                        } else {
                            count = 0;
                        }
                    } else {
                        count = 0;
                    }
                    if (count == 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Determines whether or not a player has won via 4 in a row
     * in top to right diagonals.
     *
     * @return true or false
     */
    private static boolean isTopRightDiagonalVictory(String token) {
        for (int row = 0; row < GAME_HEIGHT; row++) {
            for (int col = GAME_WIDTH - 1; col >= 0; col--) {
                int count = 0;
                for (int delta = 0; delta < 5; delta++) {
                    if (withinBounds(row + delta, col - delta)
                            && board[row + delta][col - delta] != null) {
                        if (board[row + delta][col - delta].equals(token)) {
                            count++;
                        } else {
                            count = 0;
                        }
                    } else {
                        count = 0;
                    }
                    if (count == 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Small bounds checker helper method.
     */
    private static boolean withinBounds(int row, int col) {
        return (row < GAME_HEIGHT && row >= 0)
            && (col < GAME_WIDTH && col >= 0);
    }
}
