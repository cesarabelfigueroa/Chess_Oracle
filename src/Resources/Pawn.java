package Resources;

import static java.lang.Math.abs;

public class Pawn extends Piece {

    public Pawn(int player) {
        super(player);
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public boolean validation(Piece[][] board, int x1, int y1, int x2, int y2) {
        if (board[x1][y1].getPlayer() == 1) {
            if ((board[x2][y2].getPlayer()) == 0) {
                if ((x1 == 6) && ((x1 - x2) == 2) && (y1 == y2)) {
                    return (board[x1 - 1][y1].getPlayer()) == 0;
                } else {
                    return ((x1 - x2) == 1) && (y1 == y2);
                }
            } else if ((board[x2][y2].getPlayer()) == 2) {
                return ((x1 - x2) == 1) && (abs(y1 - y2) == 1);
            }
        } else if (board[x1][y1].getPlayer() == 2) {
            if ((board[x2][y2].getPlayer()) == 0) {
                if ((x1 == 1) && ((x2 - x1) == 2) && (y1 == y2)) {
                    return (board[x1 + 1][y1].getPlayer()) == 0;
                } else return ((x2 - x1) == 1) && (y1 == y2);
            } else if ((board[x2][y2].getPlayer()) == 2) {
                return ((x2 - x1) == 1) && (abs(y1 - y2) == 1);
            }
        }
        return false;
    }
}
