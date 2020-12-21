package pt.ulusofona.lp2.theWalkingDEISIGame;

public class CriancaVivo extends Vivo {
    public CriancaVivo(String nome, int posX, int posY) {
        super(5, nome, posX, posY);
    }

    @Override
    boolean move() {
        return false;
    }
}
