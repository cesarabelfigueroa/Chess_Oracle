package Structures;

import static java.lang.Math.abs;

/**
 *
 * @author Herbert Paz
 */
public class Knight extends Piece{

    public Knight(int jugador) {
        super(jugador);
    }

    @Override
    public String toString() {
        return "C";
    }
    

    @Override
    public boolean validation(Piece[][] board, int x1, int y1, int x2, int y2) {
        return ((abs(x1 - x2) == 2) && (abs(y1 - y2) == 1)) || ((abs(x1 - x2) == 1) && (abs(y1 - y2) == 2));
    }
    
}
