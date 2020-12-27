package pt.ulusofona.lp2.theWalkingDEISIGame;

public class AdultoVivo extends Vivo {
    public AdultoVivo(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura,6, nome, posX, posY);
    }

    @Override
    public boolean isValidMove(int xO, int yO, int xD, int yD) {
        if (xO == xD && yO == yD) {
            return false;
        }
        int xOffset=xD-xO;
        int yOffset=yD-yO;
        return (xD==xO && yD <= yO +2 && yD >= yO -2) /*VERTICAL*/
                || (yD == yO && xD<= xO +2 && xD >= xO-2) /*HORIZONTAL*/
                || (Math.abs(xOffset) == Math.abs(yOffset) && Math.abs(xOffset)<3 && Math.abs(yOffset)<3); /*DIAGONAIS*/
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
        return "steve.png";
    }
}
