package finalChess;

public class Move {
    private Square source;
    private Square target;

    public Move(Square source, Square target) {
        this.source = source;
        this.target = target;
    }

    public Square getSource() {
        return source;
    }

    public Square getTarget() {
        return target;
    }
}
