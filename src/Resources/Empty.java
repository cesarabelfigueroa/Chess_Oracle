package Resources;

public class Empty extends Piece{

    public Empty(int jugador) {
        super(jugador);
    }

    @Override
    public String toString() {
        return "-";
    }
    

    @Override
    public boolean validation(Piece[][] board, int x1, int y1, int x2, int y2) {
        return false;
    }
}