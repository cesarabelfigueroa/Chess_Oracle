package Structures;

/**
 *
 * @author Herbert Paz
 */
public class Movement {
    private Piece piece;
    private String coor1;
    private String coor2;

    public Movement() {
    }

    public Movement(Piece piece, String coor1, String coor2) {
        this.piece = piece;
        this.coor1 = coor1;
        this.coor2 = coor2;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public String getCoor1() {
        return coor1;
    }

    public void setCoor1(String coor1) {
        this.coor1 = coor1;
    }

    public String getCoor2() {
        return coor2;
    }

    public void setCoor2(String coor2) {
        this.coor2 = coor2;
    }

    @Override
    public String toString() {
        return "La pieza "  + piece.toString() + " se movio de: " + coor1 + " a: " + coor2;
    }
    
    
}
