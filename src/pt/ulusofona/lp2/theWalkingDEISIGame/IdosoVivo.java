package pt.ulusofona.lp2.theWalkingDEISIGame;

public class IdosoVivo extends Vivo {
    public IdosoVivo(String nome, int posX, int posY) {
        super(8, nome, posX, posY);
    }

    @Override
    public boolean move(int xD, int yD) {
        return false;
    }

    @Override
    public boolean isValidMove(int xO, int yO, int xD, int yD) {
        if (xO == xD && yO == yD || !TWDGameManager.isDay()) {
            return false;
        }
        return (xD != yD && xD > xO - 1 && xD < xO + 1 && yD > yO - 1 && yD < yO + 1);
    }
}
