package pt.ulusofona.lp2.theWalkingDEISIGame;

public class IdosoZombie extends Zombie {
    public IdosoZombie(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura,3, nome, posX, posY);
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
        return "oldZombie.png";
    }
}
