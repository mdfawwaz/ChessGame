package chessGame;

public class ChessPieceFactory {
    public static ChessPiece createPiece(char pieceSymbol) {
        Color pieceColor = Character.isUpperCase(pieceSymbol) ? Color.WHITE : Color.BLACK;

        switch (Character.toUpperCase(pieceSymbol)) {
            case 'K':
                return new King(pieceColor);
            case 'Q':
                return new Queen(pieceColor);
            case 'R':
                return new Rook(pieceColor);
            case 'N':
                return new Knight(pieceColor);
            case 'B':
                return new Bishop(pieceColor);
            case 'P':
                return new Pawn(pieceColor);
            default:
                return null; // Placeholder for empty squares ('_')
        }
    }
}
