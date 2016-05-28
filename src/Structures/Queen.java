package Structures;

/**
 *
 * @author Herbert Paz
 */
public class Queen extends Piece {

    public Queen(int jugador) {
        super(jugador);
    }

    @Override
    public boolean validation(Piece[][] board, int x1, int y1, int x2, int y2) {
        return (tower(board,x1,y1,x2,y2)||bishop(board,x1,y1,x2,y2))==true;
}

    private boolean tower(Piece[][] board, int x1, int y1, int x2, int y2) {
        if ((x1 == x2) || (y1 == y2)) {
            if ((x1 > x2) && (y1 == y2)) {
                int cont = 0;
                for (int i = x1 - 1; i > x2; i--) {
                    if ((board[i][y1].getPlayer()) != 0) {
                        cont++;
                    }
                }
                return cont == 0;
            } else if ((x1 < x2) && (y1 == y2)) {
                int cont = 0;
                for (int i = x1 + 1; i < x2; i++) {
                    if ((board[i][y1].getPlayer()) != 0) {
                        cont++;
                    }
                }
                return cont == 0;
            } else if ((x1 == x2) && (y1 > y2)) {
                int cont = 0;
                for (int i = y1 - 1; i > y2; i--) {
                    if ((board[x1][i].getPlayer()) != 0) {
                        cont++;
                    }
                }
                return cont == 0;
            } else if ((x1 == x2) && (y1 < y2)) {
                int cont = 0;
                for (int i = y1 + 1; i < y2; i++) {
                    if ((board[x1][i].getPlayer()) != 0) {
                        cont++;
                    }
                }
                return cont == 0;
            }
        } else {
            return false;
        }
        return false;
    }

    private boolean bishop(Piece[][] board, int x1, int y1, int x2, int y2) {
        if (((x1 - y1) == (x2 - y2)) || ((x1 + y1) == (x2 + y2))) {
            if ((x1 > x2) && (y1 > y2)) {
                int cont = 0;
                for (int i = 1; i < (x1 - x2); i++) {
                    if ((board[x1 - i][y1 - i].getPlayer()) != 0) {
                        cont++;
                    }
                }
                return cont == 0;
            } else if ((x1 < x2) && (y1 > y2)) {
                int cont = 0;
                for (int i = 1; i < (x2 - x1); i++) {
                    if ((board[x1 + i][y1 - i].getPlayer()) != 0) {
                        cont++;
                    }
                }
                return cont == 0;
            } else if ((x1 < x2) && (y1 < y2)) {
                int cont = 0;
                for (int i = 1; i < (x2 - x1); i++) {
                    if ((board[x1 + i][y1 + i].getPlayer()) != 0) {
                        cont++;
                    }
                }
                return cont == 0;
            } else if ((x1 > x2) && (y1 < y2)) {
                int cont = 0;
                for (int i = 1; i < (x1 - x2); i++) {
                    if ((board[x1 - i][y1 + i].getPlayer()) != 0) {
                        cont++;
                    }
                }
                return cont == 0;
            }
        } else {
            return false;
        }
        return false;
    }
}

