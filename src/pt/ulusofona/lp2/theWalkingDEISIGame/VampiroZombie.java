package pt.ulusofona.lp2.theWalkingDEISIGame;

public class VampiroZombie extends Zombie {
    public VampiroZombie(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura, 4, nome, posX, posY);
    }

    @Override
    public boolean isValidMove(int xO, int yO, int xD, int yD) {
        GameInfo gameInfo = GameInfo.getInstance();
        if ((xO == xD && yO == yD) || gameInfo.isDay()) {
            return false;
        }
        return (xD == xO && yD >= yO - 2 && yD <= yO + 2) || (yD == yO && xD >= xO - 2 && xD <= xO + 2) ||
                (xD == yD && xD <= xO + 2 && xD >= xO - 2) || (xD == -1 * yD && xD <= xO + 2 && xD >= xO - 2);
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

    public String getImagePNG() {
        return null;
    }
}
