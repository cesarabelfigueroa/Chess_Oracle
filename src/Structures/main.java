/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

import Resources.Piece;
import Resources.Mapping;
import Resources.Pawn;
import Resources.Empty;
import Resources.King;
import Resources.Knight;
import Resources.Movement;
import Resources.Queen;

/**
 *
 * @author Herbert Paz
 */
public class main {

    public static void main(String[] args) {
        Piece[][] principal_board = new Piece[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                principal_board[i][j] = new Empty(0);
            }
        }
        //principal_board[1][1] = new Pawn(1);
        //principal_board[0][4] = new Knight(2);
        principal_board[1][3] = new King(2);
        principal_board[1][6] = new Pawn(2);
        principal_board[3][3] = new Pawn(1);
        principal_board[3][5] = new Pawn(1);
        principal_board[4][4] = new King(1);
        Movement principal = new Movement(new Empty(0), "0,0", "0,0");
        Tree root = new Tree(new Mapping(principal_board, principal));
        LinkedList lista_peon = new LinkedList();
        //traverse_tree(root.getRoot(), 0, lista_peon);
        mapping(root.getRoot(), 0, lista_peon);
        System.out.println(lista_peon.size());
    }

    public static Piece[][] copy_board(Piece[][] board) {
        Piece[][] temporal = new Piece[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                temporal[i][j] = board[i][j];
            }
        }
        return temporal;
    }

    public static void mapping(TreeNode currentNode, int cont, LinkedList lista_peon) {
        if (currentNode.getParent() != null) {
            if (currentNode.getRigthBrother() != null) {
                traverse_tree(currentNode, cont, lista_peon);
                mapping(currentNode.getRigthBrother(), cont, lista_peon);
            } else if (currentNode.getParent().getLeftSon().getChildAt(0) != null) {
                traverse_tree(currentNode, cont, lista_peon);
                mapping(currentNode.getParent().getLeftSon().getChildAt(0), cont + 1, lista_peon);
            }
        } else {
            traverse_tree(currentNode, 0, lista_peon);
            mapping(currentNode.getLeftSon(), cont + 1, lista_peon);
        }
    }

    public static void traverse_tree(TreeNode currentNode, int cont, LinkedList lista_peon) {
        if (currentNode.getDepth() < 25) {
            LinkedList check = new LinkedList();
            LinkedList knight = new LinkedList();
            LinkedList queen = new LinkedList();
            int player;
            if (cont % 2 == 0) {
                player = 1;
            } else {
                player = 2;
            }
            System.out.println("EL jugador es: " + player);
            System.out.println("");
            Mapping temp = (Mapping) currentNode.getValue();
            Piece[][] father_board = temp.getBoard();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 8; k++) {
                        for (int l = 0; l < 8; l++) {
                            if (father_board[i][j].getPlayer() == player) {
                                if (father_board[i][j].validation(father_board, i, j, k, l)) {
                                    Piece[][] board = copy_board(father_board);
                                    if (board[i][j].getPlayer() == 1 && (board[k][l].getPlayer() == 2 || board[k][l].getPlayer() == 0)) {
                                        int x1, y1, x2, y2;
                                        if (cont == 0) {
                                            x1 = i;
                                            y1 = j;
                                            x2 = k;
                                            y2 = l;
                                        } else {
                                            Mapping father = (Mapping) currentNode.getParent().getValue();
                                            Movement previous = father.getLast();
                                            String coo1 = previous.getCoor1();
                                            String coo2 = previous.getCoor2();
                                            String[] split1 = coo1.split(",");
                                            String[] split2 = coo2.split(",");
                                            x1 = Integer.parseInt(split1[0]);
                                            y1 = Integer.parseInt(split1[1]);
                                            x2 = Integer.parseInt(split2[0]);
                                            y2 = Integer.parseInt(split2[1]);
                                        }
                                        if (x1 == k && y1 == l && x2 == i && y2 == j) {
                                        } else if (board[k][l] instanceof King) {
                                        } else {
                                            board[k][l] = board[i][j];
                                            board[i][j] = new Empty(0);
                                            String coor1 = i + "," + j;
                                            String coor2 = k + "," + l;
                                            Movement last = new Movement(board[k][l], coor1, coor2);
                                            for (int a = 0; a < 8; a++) {
                                                for (int b = 0; b < 8; b++) {
                                                    System.out.print(board[a][b] + " ");
                                                }
                                                System.out.println("");
                                            }
                                            Mapping map = new Mapping(board, last);
                                            if (board[k][l] instanceof Pawn) {
                                                if (k == 0) {
                                                    lista_peon.push_back(map);
                                                    System.err.println("LLEGOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
                                                }
                                            }

                                            if (isCheck(board, player)) {
                                                check.push_back(map);
                                            }

                                            if (wasEatKhigth(father_board, board)) {
                                                knight.push_back(map);
                                            }

                                            if (wasEatQueen(father_board, board)) {
                                                queen.push_back(map);
                                            }
                                            System.out.println("");
                                            currentNode.addSon(map);
                                        }
                                    } else if (board[i][j].getPlayer() == 2 && (board[k][l].getPlayer() == 1 || board[k][l].getPlayer() == 0)) {
                                        int x1, y1, x2, y2;
                                        if (cont == 0) {
                                            x1 = i;
                                            y1 = j;
                                            x2 = k;
                                            y2 = l;
                                        } else {
                                            Mapping father = (Mapping) currentNode.getParent().getValue();
                                            Movement previous = father.getLast();
                                            String coo1 = previous.getCoor1();
                                            String coo2 = previous.getCoor2();
                                            String[] split1 = coo1.split(",");
                                            String[] split2 = coo2.split(",");
                                            x1 = Integer.parseInt(split1[0]);
                                            y1 = Integer.parseInt(split1[1]);
                                            x2 = Integer.parseInt(split2[0]);
                                            y2 = Integer.parseInt(split2[1]);
                                        }
                                        if (x1 == k && y1 == l && x2 == i && y2 == j) {
                                        } else if (board[k][l] instanceof King) {
                                        } else {
                                            board[k][l] = board[i][j];
                                            board[i][j] = new Empty(0);
                                            String coor1 = i + "," + j;
                                            String coor2 = k + "," + l;
                                            Movement last = new Movement(board[k][l], coor1, coor2);
                                            Mapping map = new Mapping(board, last);
                                            if (board[k][l] instanceof Pawn) {
                                                if (k == 6) {
                                                    lista_peon.push_back(map);
                                                }
                                            }
                                            if (isCheck(board, player)) {
                                                check.push_back(map);
                                            }

                                            if (wasEatKhigth(father_board, board)) {
                                                knight.push_back(map);
                                            }

                                            if (wasEatQueen(father_board, board)) {
                                                queen.push_back(map);
                                            }

                                            currentNode.addSon(map);
                                            for (int a = 0; a < 8; a++) {
                                                for (int b = 0; b < 8; b++) {
                                                    System.out.print(board[a][b] + " ");
                                                }
                                                System.out.println("");
                                            }
                                            System.out.println("");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean wasEatKhigth(Piece[][] board, Piece[][] board2) {
        int horse1 = 0;
        int horse2 = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] instanceof Knight) {
                    horse1++;
                }
                if (board2[i][j] instanceof Knight) {
                    horse2++;
                }
            }
        }
        return horse1 == horse2;
    }

    public static boolean wasEatQueen(Piece[][] board, Piece[][] board2) {
        int queen1 = 0;
        int queen2 = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] instanceof Knight) {
                    queen1++;
                }
                if (board2[i][j] instanceof Knight) {
                    queen2++;
                }
            }
        }
        return queen1 == queen2;
    }

    public static boolean isCheck(Piece[][] board, int player) {
        String placeToKing = placeToKing(board, player);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String tempPosition = "" + i + "," + j;
                if (isValidMove(board, tempPosition, placeToKing)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String placeToKing(Piece[][] board, int player) {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] instanceof King && board[i][j].getPlayer() == player) {
                    return "" + i + "," + j;
                }
            }
        }
        return "";
    }

    public static boolean isValidMove(Piece[][] board, String initial, String end) {
        int initialX = Integer.parseInt(initial.split(",")[0]);
        int initialY = Integer.parseInt(initial.split(",")[1]);
        int endX = Integer.parseInt(end.split(",")[0]);
        int endY = Integer.parseInt(end.split(",")[1]);
        if (endX < 0 || endX > 7 || endY < 0 || endY > 7 || initialX < 0 || initialX > 7 || initialY < 0 || initialY > 7) {
            return false;
        } else {
            boolean isEmpty = isEmpty(board, initial);
            boolean isValidDestiny = isValidDestiny(board, initial, end);
            boolean isValidMove = board[initialX][initialY].validation(board, initialX, initialY, endX, endY);
            boolean isHungryPeon = isHungryPeon(board, initial, end);
            return !isEmpty && isValidDestiny && (isValidMove || isHungryPeon);
        }
    }

    public static boolean isSomethingInMiddle(Piece[][] board, String initial, String end) {
        int initX = Integer.parseInt(initial.split(",")[0]);
        int initY = Integer.parseInt(initial.split(",")[1]);
        int endX = Integer.parseInt(end.split(",")[0]);
        int endY = Integer.parseInt(end.split(",")[1]);
        Piece attacker = board[initX][initY];
        Piece attacked = board[endX][endY];
        if (attacker instanceof Pawn) {
            return (!(attacked instanceof Empty)) && !isHungryPeon(board, initial, end);
        } else if (attacker instanceof Knight) {
            return false;
        } else if (attacker instanceof King) {
            return false;
        } else if (board[initX][initY] instanceof Queen) {
            if (initX + initY == endX + endY) {
                if (endX < initX && endY > initY) {
                    int referencesY = endY - 1;
                    for (int i = endX + 1; i < initX; ++i) {
                        if (!(board[i][referencesY] instanceof Empty)) {
                            return true;
                        }
                        referencesY--;
                    }
                    return false;
                } else if (endX > initX && endY < initY) {
                    int referencesY = endY + 1;
                    for (int i = endX - 1; i > initX; --i) {
                        if (!(board[i][referencesY] instanceof Empty)) {
                            return true;
                        }
                        referencesY++;
                    }
                    return false;
                }
            } else if (initX - initY == endX - endY) {
                if (endX < initX && endY < initY) {
                    int referencesY = endY + 1;
                    for (int i = endX + 1; i < initX; ++i) {
                        if (!(board[i][referencesY] instanceof Empty)) {
                            return true;
                        }
                        referencesY++;
                    }
                    return false;
                } else if (endX > initX && endY > initY) {
                    int referencesY = endY - 1;
                    for (int i = endX - 1; i > initX; --i) {
                        if (!(board[i][referencesY] instanceof Empty)) {
                            return true;
                        }
                        referencesY--;
                    }
                    return false;
                }
            }
            if (endY > initY) { // se mueve a la derecha.
                for (int i = endY - 1; i > initY; --i) {
                    if (!(board[initX][i] instanceof Empty)) {
                        return true;
                    }
                }
                return false;
            } else if (initY > endY) { // se mueve a la izquierda.
                for (int i = endY + 1; i < initY; ++i) {
                    if (!(board[initX][i] instanceof Empty)) {
                        return true;
                    }
                }
                return false;
            } else if (endX > initX) { // se mueve a abajo.
                for (int i = endX - 1; i > initX; --i) {
                    if (!(board[i][initY] instanceof Empty)) {
                        return true;
                    }
                }
                return false;
            } else if (initX > endX) { // se mueve a la arriba.
                for (int i = endX + 1; i < initX; ++i) {
                    if (!(board[i][initY] instanceof Empty)) {
                        return true;
                    }
                }
                return false;
            }
        }

        return false;
    }

    public static boolean isHungryPeon(Piece[][] board, String initial, String end) {
        int initialX = Integer.parseInt(initial.split(",")[0]);
        int initialY = Integer.parseInt(initial.split(",")[1]);
        int endX = Integer.parseInt(end.split(",")[0]);
        int endY = Integer.parseInt(end.split(",")[1]);
        Piece attacker = board[initialX][initialY];
        Piece attacked = board[endX][endY];
        if (attacker instanceof Pawn) {
            if (!(attacked instanceof Empty)) {
                if (attacker.getPlayer() == 1) {
                    if (endX == initialX - 1 && endY == initialY + 1) {
                        return true;
                    } else if (endX == initialX - 1 && endY == initialY - 1) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (attacker.getPlayer() == 2) {
                    if (endX == initialX + 1 && endY == initialY + 1) {
                        return true;
                    } else if (endX == initialX + 1 && endY == initialY - 1) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isEmpty(Piece[][] board, String initial) {
        int initialX = Integer.parseInt(initial.split(",")[0]);
        int initialY = Integer.parseInt(initial.split(",")[1]);
        return board[initialX][initialY] instanceof Empty;
    }

    public static boolean isValidDestiny(Piece[][] board, String initial, String end) {
        return !isSameColor(board, initial, end) && !isSomethingInMiddle(board, initial, end);
    }

    public static boolean isSameColor(Piece[][] board, String initial, String end) {
        int initialX = Integer.parseInt(initial.split(",")[0]);
        int initialY = Integer.parseInt(initial.split(",")[1]);
        int endX = Integer.parseInt(end.split(",")[0]);
        int endY = Integer.parseInt(end.split(",")[1]);
        return board[endX][endY].getPlayer() == board[initialX][initialY].getPlayer();
    }
}
