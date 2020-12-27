package pt.ulusofona.lp2.theWalkingDEISIGame;

public class AdultoZombie extends Zombie {
    public AdultoZombie(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura, 1, nome, posX, posY);
    }

    @Override
    public boolean isValidMove(int xO, int yO, int xD, int yD) {
        if (xO == xD && yO == yD ) {
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

    public String getImagePNG(){
        return "zombie.png";
    }
}
