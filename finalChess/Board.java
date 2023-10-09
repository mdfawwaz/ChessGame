package finalChess;

public class Board {
    private Piece[][] pieces;

    public Board() {
        pieces = new Piece[8][8];
    }

    public void initialize() {

        String[] startingPosition = {
            "rnbqkbnr",
            "pppppppp",
            "        ",
            "        ",
            "        ",
            "        ",
            "PPPPPPPP",
            "RNBQKBNR"
        };

        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                char pieceSymbol = startingPosition[rank].charAt(file);
                pieces[rank][file] = createPieceFromSymbol(pieceSymbol);
            }
        }
    }
    
    

    private Piece createPieceFromSymbol(char symbol) {
       
        return Piece.EMPTY;
    }

    public boolean isValidMove(Move move) {
       
        return true;
    }

 

    public void printBoard() {
        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                System.out.print(getPieceSymbol(pieces[rank][file]) + " ");
            }
            System.out.println();
        }
    }

    private String getPieceSymbol(Piece piece) {
       
        return " ";
    }

	public void makeMove(Move move) {
		// TODO Auto-generated method stub
		
	}
    public class Board<E> implements Chess <E> {
    }
	
}
