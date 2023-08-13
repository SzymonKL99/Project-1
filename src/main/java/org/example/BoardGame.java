package org.example;
import java.util.Scanner;
import static org.example.GameLogic.isValidMove;
import static org.example.GameLogic.placeMove;

public class BoardGame {

    public static int selectBoardSize(Scanner scanner) {
        System.out.println("Select board size: ");
        System.out.println("1. Size 3x3");
        System.out.println("2. Size 10x10");

        while (true) {
            String userInput = scanner.nextLine();
            if (userInput.equals("1")) {
                return 3;
            } else if (userInput.equals("2")) {
                return 10;
            }else {
                System.out.println("Inwalid choice. Please select board size (1 or 2)");

            }
        }
    }
    public static int selectGameMode(Scanner scanner) {
        System.out.println("Select game mode:");
        System.out.println("1. Two Players");
        System.out.println("2. Play against Computer");

        while (true) {
            String userInput = scanner.nextLine();
            if (userInput.equals("1") || userInput.equals("2")) {
                return Integer.parseInt(userInput);
            } else {
                System.out.println("Invalid choice. Please select game mode (1 or 2):");
            }
        }
    }
    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = ' ';
            }
        }
    }
    public static void playerTurn(char[][] board, Scanner scanner, char symbol) {
        String userInput;
        while (true) {
            System.out.println("Player " + symbol + ": Where would you like to play? (1-9) ");
            userInput = scanner.nextLine();
            if (isValidMove(board, userInput)) {
                break;
            } else {
                System.out.println(userInput + ": is not a valid move");
            }
        }
        placeMove(board, userInput, symbol);
    }
    public static void printBoard(char[][] board) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j]);
                if (j < size - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < size - 1) {
                for (int k = 0; k < size; k++) {
                    System.out.print("-");
                    if (k < size - 1) {
                        System.out.print("+");
                    }
                }
                System.out.println();
            }
        }
    }
}
