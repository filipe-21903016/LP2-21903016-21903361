package pt.ulusofona.lp2.theWalkingDEISIGame;

public class IdosoVivo extends Vivo {
    public IdosoVivo(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura, 8, nome, posX, posY);
    }

    @Override
    public boolean move(int xD, int yD) {
        GameInfo gameInfo = GameInfo.getInstance();
        int id = gameInfo.getElementId(xD,yD);

        if(id<0){ //entao é id de equipamento
            if(equipment!=null){
                gameInfo.addEquipment(dropEquipment());
            }
            Equipamento equipamento = gameInfo.getEquipmentById(id);
            pickEquipment(equipamento);
            gameInfo.removeEquipment(equipamento);
        }
        posX = xD;
        posY = yD;
        return true;
    }

    @Override
    public boolean isValidMove(int xO, int yO, int xD, int yD) {
        GameInfo gameInfo = GameInfo.getInstance();
        if ((xO == xD && yO == yD) || !gameInfo.isDay()) {
            return false;
        }
        return (xD != yD && xD >= xO - 1 && xD <= xO + 1 && yD >= yO - 1 && yD <= yO + 1);
    }

    public String getImagePNG() {
        return "oldMan.png";
    }
}
