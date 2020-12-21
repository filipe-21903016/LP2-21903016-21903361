package pt.ulusofona.lp2.theWalkingDEISIGame;

public class MilitarZombie extends Zombie {
    public MilitarZombie(String nome, int posX, int posY) {
        super(2, nome, posX, posY);
    }

    @Override
    public boolean isValidMove(int xO, int yO, int xD, int yD) {
        if(xO==xD && yO==yD){
            return false;
        }
        return (xD==xO && yD>=yO-3 && yD<=yO+3) || (yD==yO && xD>=xO-3 && xD<=xO+3) ||
                (xD==yD && xD<=xO+3 && xD>= xO-3) || (xD==-1*yD && xD<=xO+3 && xD>= xO-3) ;

    }

    @Override
    public boolean move(int xD, int yD) {
        return false;
    }
}
