package Structures;
/**
 *
 * @author Herbert Paz
 */
public class Mapping {
    private Piece[][] board;
    private Movement last;

    public Mapping() {
    }

    public Mapping(Piece[][] board, Movement last) {
        this.board = board;
        this.last = last;
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }

    public Movement getLast() {
        return last;
    }

    public void setLast(Movement last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "" + last ;
    }
    
    
}
