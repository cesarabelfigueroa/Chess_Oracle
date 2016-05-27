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
        principal_board[0][4] = new Knight(2);
        principal_board[1][3] = new King(2);
        principal_board[1][6] = new Pawn(2);
        principal_board[3][3] = new Pawn(1);
        principal_board[3][5] = new Pawn(1);
        principal_board[5][4] = new King(1);
        Tree root = new Tree(principal_board);
        Piece[][] father_board = (Piece[][]) (root.getRoot()).getValue();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (father_board[i][j].getPlayer() == 2) {
                            if (father_board[i][j].validation(father_board, i, j, k, l)) {
                                Piece[][] board = copy_board(father_board);
                                board[k][l] = board[i][j];
                                board[i][j] = new Empty(0);
                                String coor1 = "(" + i + "," + j + ")";
                                String coor2 = "(" + k + "," + l + ")";
                                Movement last = new Movement(board[k][l], coor1, coor2);
                                root.getRoot().addSon(new Mapping(board, last));
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(principal_board[i][j] + " ");
            }
            System.out.println("");
        }
        root.PreeOrden();
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
}
