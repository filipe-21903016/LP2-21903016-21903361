package pt.ulusofona.lp2.theWalkingDEISIGame;

public class AdultoVivo extends Vivo {
    public AdultoVivo(String nome, int posX, int posY) {
        super(6, nome, posX, posY);
    }

    @Override
    boolean move() {
        return false;
    }
}
