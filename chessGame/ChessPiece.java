package chessGame;
public abstract class ChessPiece {
    private Color color;

    public ChessPiece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol);
}

class King extends ChessPiece {
    public King(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);
        return rowDiff <= 1 && colDiff <= 1;
    }
}

class Queen extends ChessPiece {
    public Queen(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);
        return rowDiff == colDiff || fromRow == toRow || fromCol == toCol;
    }
}

class Rook extends ChessPiece {
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
        return fromRow == toRow || fromCol == toCol;
    }
}

class Bishop extends ChessPiece {
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);
        return rowDiff == colDiff;
    }
}

class Knight extends ChessPiece {
    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }
}

class Pawn extends ChessPiece {
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
        int rowDiff = toRow - fromRow;
        int colDiff = Math.abs(toCol - fromCol);

        if (getColor() == Color.WHITE) {
            return rowDiff == -1 && colDiff <= 1;
        } else {
            return rowDiff == 1 && colDiff <= 1;
        }
    }
}
