package Structures;

import static java.lang.Math.abs;

/**
 *
 * @author Herbert Paz
 */
public class King extends Piece{

    public King(int jugador) {
        super(jugador);
    }

    @Override
    public String toString() {
        return "K";
    }
    
    
    @Override
    public boolean validation(Piece[][] board, int x1, int y1, int x2, int y2) {
        return ((abs(x1 - x2) == 1) && (abs(y1 - y2) == 1)) || ((x1 == x2) && (abs(y1 - y2) == 1)) || ((y1 == y2) && (abs(x1 - x2) == 1));
    }
    
}
