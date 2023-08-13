import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.GameLogic;


public class TicTacToeTest {
    @Test
    public void testPlayerOWinsInRows() {
        char[][] board = {
                {'O', 'O', 'O'},
                {'X', 'X', ' '},
                {' ', ' ', 'X'}
        };
        assertTrue(GameLogic.hasContestantWon(board, 'O'));
    }
    @Test
    public void testPlayerOWinsInColumns() {
        char[][] board = {
                {'O', 'X', 'X'},
                {'O', ' ', 'X'},
                {'O', ' ', ' '}
        };
        assertTrue(GameLogic.hasContestantWon(board, 'O'));
    }
    @Test
    public void testPLayerOWinsDiagonal() {
        char[][] board = {
                {'O', ' ', ' '},
                {' ', 'O', ' '},
                {' ', ' ', 'O'}
        };
        assertTrue(GameLogic.hasContestantWon(board, 'O'));
    }
    @Test
    public void testPlayerXWinsInRows() {
        char[][] board = {
                {'X', 'X', 'X'},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        assertTrue(GameLogic.hasContestantWon(board, 'X'));
    }
    @Test
    public void testPlayerXWinsInColumns() {
        char[][] board = {
                {'X', ' ', ' '},
                {'X', ' ', ' '},
                {'X', ' ', ' '}
        };
        assertTrue(GameLogic.hasContestantWon(board, 'X'));
    }
    @Test
    public void testPLayerXWinsDiagonal() {
        char[][] board = {
                {'X', ' ', ' '},
                {' ', 'X', ' '},
                {' ', ' ', 'X'}
        };
        assertTrue(GameLogic.hasContestantWon(board, 'X'));
    }
    @Test
    public void testGameEndsInDraw() {
        char[][] board = {
                {'O', 'X', 'O'},
                {'X', 'O', 'X'},
                {'X', 'O', 'X'}
        };

        assertTrue(GameLogic.isGameFinished(board));
    }
    @Test
    public void testIsValidMove_True() {
        char[][] board = {
                {'X', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        assertTrue(GameLogic.isValidMove(board, "2"));
    }

    @Test
    public void testIsValidMove_False() {
        char[][] board = {
                {'X', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        assertFalse(GameLogic.isValidMove(board, "1"));
    }
}