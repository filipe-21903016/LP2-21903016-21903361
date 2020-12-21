package pt.ulusofona.lp2.theWalkingDEISIGame;

public class Cao extends Vivo {
    public Cao(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura, nome, posX, posY);
    }

    @Override
    public boolean isValidMove(int xO, int yO, int xD, int yD) {
        return false;
    }

    @Override
    public boolean move(int xD, int yD) {
        return false;
    }
}
