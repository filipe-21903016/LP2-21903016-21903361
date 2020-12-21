package pt.ulusofona.lp2.theWalkingDEISIGame;

public class IdosoZombie extends Zombie {
    public IdosoZombie(String nome, int posX, int posY) {
        super(3, nome, posX, posY);
    }

    @Override
    public boolean isValidMove(int xO, int yO, int xD, int yD) {
        if (xO == xD && yO == yD) {
            return false;
        }
        return (xD != yD && xD > xO - 1 && xD < xO + 1 && yD > yO - 1 && yD < yO + 1);
    }

    @Override
    public boolean move(int xD, int yD) {
        return false;
    }
}
