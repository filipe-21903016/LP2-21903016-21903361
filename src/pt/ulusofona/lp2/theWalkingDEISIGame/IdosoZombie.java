package pt.ulusofona.lp2.theWalkingDEISIGame;

public class IdosoZombie extends Zombie{
    public IdosoZombie(String nome, int posX, int posY) {
        super(3, nome, posX, posY);
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
