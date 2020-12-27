package pt.ulusofona.lp2.theWalkingDEISIGame;

public class Cao extends Vivo {
    public Cao(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura,9,nome, posX, posY);
        nomeTipo="Cão";
    }

    @Override
    public boolean isValidMove(int xO, int yO, int xD, int yD) {
        if (xO == xD && yO == yD) {
            return false;
        }
        int xOffset=xD-xO;
        int yOffset=yD-yO;
        return (Math.abs(xOffset) == Math.abs(yOffset) && Math.abs(xOffset) < 3 && Math.abs(yOffset) < 3);
        /*DIAGONAIS*/
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
        return "dog.png";
    }

}
