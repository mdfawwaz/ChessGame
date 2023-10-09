package chessGame;

public class ChessBoard {
	private char[][] board;
public ChessBoard() {

	board = new char[8][8];

	initializeBoard();

}

private void initializeBoard() {

	board[0][0] = 'R';
	board[0][1] = 'N';
	board[0][2] = 'B';
	board[0][3] = 'Q';
	board[0][4] = 'K';
	board[0][5] = 'B';
	board[0][6] = 'N';
	board[0][7] = 'R';

	for (int i = 0; i < 8; i++) {
		board[1][i] = 'P';
	}


	board[7][0] = 'r';
	board[7][1] = 'n';
	board[7][2] = 'b';
	board[7][3] = 'q';
	board[7][4] = 'k';
	board[7][5] = 'b';
	board[7][6] = 'n';
	board[7][7] = 'r';

	for (int i = 0; i < 8; i++) {
		board[6][i] = 'p';
	}


	for (int i = 2; i < 6; i++) {
		for (int j = 0; j < 8; j++) {
			board[i][j] = '_';
		}
	}
}



public char[][] getBoard() {

	return board;

}



public void printBoard() {

	System.out.print("  ");

	for (char c = 'a'; c <= 'h'; c++) {

		System.out.print(c + " ");

	}

	System.out.println();



	for (int i = 0; i < 8; i++) {

		System.out.print(8 - i + " ");

		for (int j = 0; j < 8; j++) {

			System.out.print(board[i][j]);

			if (j < 7) {

				System.out.print('|');

			}

		}

		System.out.println(" " + (8 - i));
	}



	System.out.print("  ");

	for (char c = 'a'; c <= 'h'; c++) {

		System.out.print(c + " ");

	}

	System.out.println();

}



public static void main(String args[]) {

	ChessBoard board = new ChessBoard();

	board.printBoard();

}

}
\

package chessGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChessGame {
    private ChessBoard board;

    public ChessGame() {
        board = new ChessBoard();
    }

    public void startGameFromFile(String filename) {
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            while (fileScanner.hasNextLine()) {
                String input = fileScanner.nextLine().trim();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                if (isValidMoveInput(input)) {
                    ChessMove move = parseMove(input);
                    if (move != null && board.isValidMove(move)) {
                        board.applyMove(move);
                        board.printBoard();
                    } else {
                        System.out.println("Invalid move. Skipping.");
                    }
                } else {
                    System.out.println("Invalid input format. Skipping.");
                }
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }

        System.out.println("Game from file completed.");
    }

    private boolean isValidMoveInput(String input) {
        return input.matches("[a-h][1-8] [a-h][1-8]");
    }

    private ChessMove parseMove(String input) {
        String[] parts = input.split(" ");
        String from = parts[0];
        String to = parts[1];
        return new ChessMove(from, to);
    }

    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        String filename = "moves.txt"; // Change this to the actual file path
        game.startGameFromFile(filename);
    }
}

