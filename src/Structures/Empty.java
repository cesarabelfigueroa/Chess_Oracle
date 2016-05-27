/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

/**
 *
 * @author Herbert Paz
 */
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
