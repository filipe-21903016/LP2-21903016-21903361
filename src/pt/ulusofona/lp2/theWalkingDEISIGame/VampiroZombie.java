package pt.ulusofona.lp2.theWalkingDEISIGame;

public class VampiroZombie extends Zombie{
    public VampiroZombie(String nome, int posX, int posY) {
        super(4, nome, posX, posY);
    }
    @Override
    public boolean isValidMove(int xO, int yO, int xD, int yD) {
        return false;
    }

    @Override
    public boolean move(int xD, int yD){
        return false;
    }
}
