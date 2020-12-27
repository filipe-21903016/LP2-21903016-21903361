package pt.ulusofona.lp2.theWalkingDEISIGame;

public class CriancaVivo extends Vivo {
    public CriancaVivo(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura,5, nome, posX, posY);
        nomeTipo="Criança (Vivo)";
    }

    @Override
    public boolean isValidMove(int xO, int yO, int xD, int yD) {
        if (xO == xD && yO == yD) {
            return false;
        }
        return (xD==xO && yD <= yO + 1 && yD >= yO - 1) /*VERTICAL*/
                || (yD == yO && xD<= xO + 1 && xD >= xO - 1); /*HORIZONTAL*/
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
        return "baby.png";
    }

}
