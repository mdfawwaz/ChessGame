package finalChess;

import java.util.Scanner;

public class Game {
    private Board board;
    private Color currentPlayer;
    private boolean isGameOver;

    public Game() {
        board = new Board();
        currentPlayer = Color.WHITE;
        isGameOver = false;
    }

    public void startGame() {
        board.initialize();
        play();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (!isGameOver) {
            board.printBoard();
            System.out.println(currentPlayer + "'s turn.");

            System.out.print("Enter your move (e.g., 'e2 e4'): ");
            String moveInput = scanner.nextLine();
            String[] moveParts = moveInput.split(" ");

            if (moveParts.length != 2) {
                System.out.println("Invalid move format. Please try again.");
                continue;
            }

            Square source = new Square();
            Square target = new Square();

            Move move = new Move(source, target);
            if (board.isValidMove(move)) {
                board.makeMove(move);
                currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
            } else {
                System.out.println("Invalid move. Please try again.");
            }

            // Check for game over conditions (e.g., checkmate, stalemate)
            if (isGameOver) {
                System.out.println("Game over!");
                // Print game result and other details
            }
        }

        scanner.close();
    }

    public String generatePGN() {
        // Generate and return PGN string for the game
        return "";
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}

