package pt.ulusofona.lp2.theWalkingDEISIGame;

public class IdosoVivo extends Vivo {
    public IdosoVivo(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura, 8, nome, posX, posY);
        nomeTipo="Idoso (Vivo)";
    }


    @Override
    public boolean move(int xO,int yO,int xD, int yD){
        if(!isValidMove(xO, yO, xD, yD)){
            return false;
        }

        GameInfo gameInfo = GameInfo.getInstance();
        int id = gameInfo.getElementId(xD,yD);

        if(equipment!=null){
            gameInfo.addEquipment(dropEquipment());
        }
        if(id<0){ //entao é id de equipamento
            Equipamento equipamento = gameInfo.getEquipmentById(id);
            pickEquipment(equipamento);
            gameInfo.removeEquipment(equipamento);
        }
        if (id==0 && gameInfo.isDoorToSafeHaven(xD, yD)){
            //add to safehaven
            enterSafeHaven();
            return true;
        }
        posX = xD;
        posY = yD;
        return true;
    }

    public String getImagePNG() {
        return "oldMan.png";
    }


}
