package pt.ulusofona.lp2.theWalkingDEISIGame;

public class Cao extends Vivo {
    public Cao(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura,9,nome, posX, posY);
        nomeTipo="Cão";
    }

    @Override
    public boolean move(int xO,int yO,int xD, int yD){
        if(!isValidMove(xO, yO, xD, yD)){
            return false;
        }

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
        if (id==0 && gameInfo.isDoorToSafeHaven(xD, yD)){
            //add to safehaven
            enterSafeHaven();
            return true;
        }
        posX = xD;
        posY = yD;
        return true;
    }

    public String getImagePNG(){
        return "dog.png";
    }

}
