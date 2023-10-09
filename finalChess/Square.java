package finalChess;
public class Square {
    private int rank; // 0 to 7
    private int file; // 0 to 7

    public Square(int rank, int file) {
        this.rank = rank;
        this.file = file;
    }

    public Square(String squareString) {
        if (squareString.length() != 2) {
            throw new IllegalArgumentException("Invalid square format");
        }

        char fileChar = squareString.charAt(0);
        char rankChar = squareString.charAt(1);

        if (fileChar < 'a' || fileChar > 'h' || rankChar < '1' || rankChar > '8') {
            throw new IllegalArgumentException("Invalid square format");
        }

        this.file = fileChar - 'a';
        this.rank = 8 - (rankChar - '1') - 1;
    }

    public int getRank() {
        return rank;
    }

    public int getFile() {
        return file;
    }

    @Override
    public String toString() {
        char fileChar = (char) ('a' + file);
        char rankChar = (char) ('1' + (7 - rank));
        return String.valueOf(fileChar) + rankChar;
    }
}
