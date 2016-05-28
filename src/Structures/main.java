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
        //principal_board[1][1] = new Pawn(1);
        principal_board[0][4] = new Knight(2);
        principal_board[1][3] = new King(2);
        principal_board[1][6] = new Pawn(2);
        principal_board[3][3] = new Pawn(1);
        principal_board[3][5] = new Pawn(1);
        //principal_board[5][4] = new King(1);
        Movement principal = new Movement(new Empty(0), "0", "0");
        Tree root = new Tree(new Mapping(principal_board, principal));
        LinkedList lista_peon = new LinkedList();
        traverse_tree(root.getRoot(), 0,lista_peon);
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

    public static void traverse_tree(TreeNode currentNode, int cont, LinkedList lista_peon) {
        int player;
        if (cont % 2 == 0) {
            player = 1;
        } else {
            player = 2;
        }
        System.out.println(player);
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
                                    board[k][l] = board[i][j];
                                    board[i][j] = new Empty(0);
                                    String coor1 = "(" + i + "," + j + ")";
                                    String coor2 = "(" + k + "," + l + ")";
                                    Movement last = new Movement(board[k][l], coor1, coor2);
                                    ////////////
                                    System.out.println(last.toString());
                                    for (int a = 0; a < 8; a++) {
                                        for (int b = 0; b < 8; b++) {
                                            System.out.print(board[a][b] + " ");
                                        }
                                        System.out.println("");
                                    }
                                    //////////////
                                    Mapping map=new Mapping(board, last);
                                    if (board[k][l] instanceof Pawn) {
                                        if (k==0) {
                                            lista_peon.push_back(map);
                                            System.err.println("EL TAMANO DE LA LISTA ES "+lista_peon.size());
                                        }
                                    }
                                    currentNode.addSon(map);
                                } else if (board[i][j].getPlayer() == 2 && (board[k][l].getPlayer() == 1 || board[k][l].getPlayer() == 0)) {
                                    board[k][l] = board[i][j];
                                    board[i][j] = new Empty(0);
                                    String coor1 = "(" + i + "," + j + ")";
                                    String coor2 = "(" + k + "," + l + ")";
                                    Movement last = new Movement(board[k][l], coor1, coor2);
                                    currentNode.addSon(new Mapping(board, last));
                                    //////////////////
                                    System.out.println(last.toString());
                                    for (int a = 0; a < 8; a++) {
                                        for (int b = 0; b < 8; b++) {
                                            System.out.print(board[a][b] + " ");
                                        }
                                        System.out.println("");
                                    }
                                    ///////////////
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < currentNode.getChildCount(); i++) {
            traverse_tree(currentNode.getChildAt(i), ++cont,lista_peon);
        }

    }

}
