package org.example;
import java.util.Random;
import static org.example.BoardGame.printBoard;

public class GameLogic {
    public static boolean isGameFinished(char[][] board) {

        if (hasContestantWon(board, 'X')) {
            printBoard(board);
            System.out.println("Player X wins!");
            return true;
        }

        if (hasContestantWon(board, 'O')) {
            printBoard(board);
            System.out.println("Player O wins!");
            return true;
        }


        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == ' ') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("The game ended in a tie!");
        return true;
    }


    public static boolean hasContestantWon(char[][] board, char symbol) {
        int size = board.length;
        int winCondition = (size == 3) ? 3 : 5;


        for (int i = 0; i < size; i++) {
            int rowCount = 0;
            int colCount = 0;
            for (int j = 0; j < size; j++) {
                if (board[i][j] == symbol) {
                    rowCount++;
                    if (rowCount == winCondition) {
                        return true;
                    }
                } else {
                    rowCount = 0;
                }

                if (board[j][i] == symbol) {
                    colCount++;
                    if (colCount == winCondition) {
                        return true;
                    }
                } else {
                    colCount = 0;
                }
            }
        }

        int diagCount1 = 0;
        int diagCount2 = 0;
        for (int i = 0; i < size; i++) {
            if (board[i][i] == symbol) {
                diagCount1++;
                if (diagCount1 == winCondition) {
                    return true;
                }
            } else {
                diagCount1 = 0;
            }

            if (board[i][size - 1 - i] == symbol) {
                diagCount2++;
                if (diagCount2 == winCondition) {
                    return true;
                }
            } else {
                diagCount2 = 0;
            }
        }

        return false;
    }
    public static void computerTurn(char[][] board) {
        Random random = new Random();

        int computerMove;
        int boardSize = board.length;

        do {
            computerMove = random.nextInt(boardSize * boardSize) + 1;
        } while (!isValidMove(board, Integer.toString(computerMove)));
        System.out.println("Computer chose: " + computerMove);
        placeMove(board, Integer.toString(computerMove), 'O');
    }

    public static boolean isValidMove (char[][] board, String position) {
        int boardSize = board.length;
        int maxPosition = boardSize * boardSize;
        int move;
        try {
            move = Integer.parseInt(position);
        }catch (NumberFormatException e) {
            return false;
        }
        return move >= 1 && move <= maxPosition && board[(move - 1) / boardSize][(move - 1) % boardSize] == ' ';
    }
    public static void placeMove(char[][] board, String position, char symbol) {
        int move = Integer.parseInt(position);
        int boardSize = board.length;
        board[(move - 1) / boardSize][(move - 1) % boardSize] = symbol;
    }

}
