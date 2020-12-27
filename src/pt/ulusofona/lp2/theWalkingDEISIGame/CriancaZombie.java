package pt.ulusofona.lp2.theWalkingDEISIGame;

public class CriancaZombie extends Zombie {
    public CriancaZombie(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura,0, nome, posX, posY);
    }
    @Override
    public boolean isValidMove(int xO, int yO, int xD, int yD) {
        if (xO == xD && yO == yD) {
            return false;
        }
        return (xD==xO && yD <= yO +1 && yD >= yO -1) /*VERTICAL*/
                || (yD == yO && xD<= xO +1 && xD >= xO-1); /*HORIZONTAL*/
    }

    @Override
    public boolean move(int xD, int yD) {
        GameInfo gameInfo = GameInfo.getInstance();
        int id = gameInfo.getElementId(xD,yD);
        if(id<0){
            Equipamento equipamento = gameInfo.getEquipmentById(id);
            destroyEquiment();
            gameInfo.removeEquipment(equipamento);
        }
        posX = xD;
        posY = yD;
        return true;
    }

    public String getImagePNG(){
        return "babyZombie.png";
    }

    @Override
    public String toString() {
        return idCriatura + " | Criança (Zombie) | " + nomeEquipa + " | " + nome
                + " " + equipmentsDestroyed + " @ (" + posX + ", " + posY + ")";
    }
}
