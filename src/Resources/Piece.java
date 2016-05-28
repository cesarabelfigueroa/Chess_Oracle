
package Resources;

/**
 *
 * @author Herbert Paz
 */
public abstract class Piece implements Interface{
    private int player;

    public Piece(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int jugador) {
        this.player = jugador;
    }

    @Override
    public String toString() {
        return "Piece{" + "jugador=" + player + '}';
    }
}