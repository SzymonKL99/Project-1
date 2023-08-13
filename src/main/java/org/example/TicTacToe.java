package org.example;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int boardSize = BoardGame.selectBoardSize(scanner);

        char[][] board = new char[boardSize][boardSize];

        int gameMode = BoardGame.selectGameMode(scanner);
        BoardGame.initializeBoard(board);

        BoardGame.printBoard(board);

        while (true) {
            if (gameMode == 1) {
                BoardGame.playerTurn(board, scanner, 'X');
            } else {
                BoardGame.playerTurn(board, scanner, 'X');
            }
            if (GameLogic.isGameFinished(board)) {
                break;
            }

            BoardGame.printBoard(board);

            if (gameMode == 1) {
                BoardGame.playerTurn(board, scanner, 'O');
            } else {
                GameLogic.computerTurn(board);
            }
            if (GameLogic.isGameFinished(board)) {
                break;
            }

            BoardGame.printBoard(board);
        }
        scanner.close();
    }
}














