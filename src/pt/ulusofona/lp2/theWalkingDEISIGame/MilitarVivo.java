package pt.ulusofona.lp2.theWalkingDEISIGame;

public class MilitarVivo extends Vivo {
    public MilitarVivo(int idCriatura,String nome, int posX, int posY) {
        super(idCriatura,7, nome, posX, posY);
    }

    @Override
    public boolean isValidMove(int xO, int yO, int xD, int yD) {
        if (xO == xD && yO == yD) {
            return false;
        }
        int xOffset=xD-xO;
        int yOffset=yD-yO;
        return (xD==xO && yD <= yO + 3 && yD >= yO - 3) /*VERTICAL*/
                || (yD == yO && xD<= xO + 3 && xD >= xO - 3) /*HORIZONTAL*/
                || (Math.abs(xOffset) == Math.abs(yOffset) && Math.abs(xOffset) < 4 && Math.abs(yOffset) < 4); /*DIAGONAIS*/
    }

    @Override
    public boolean move(int xD, int yD) {
        //se xd,yd tem equipamento apanha
        // caso tenhamos equipamento dropamos e apanhamos a nova
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

    public String getImagePNG(){
        return "soldier.png";
    }

    @Override
    public String toString() {
        return idCriatura + " | Militar (Vivo) | " + nomeEquipa + " | " + nome
                + " " + pickedEquipments + " @ (" + posX + ", " + posY + ")";
    }
}
