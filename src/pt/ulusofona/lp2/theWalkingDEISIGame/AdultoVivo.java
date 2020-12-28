package pt.ulusofona.lp2.theWalkingDEISIGame;

public class AdultoVivo extends Vivo {
    public AdultoVivo(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura,6, nome, posX, posY);
        nomeTipo="Adulto (Vivo)";
    }

    private boolean isValidMove(int xO, int yO, int xD, int yD) {
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
        }
        if(id>0){
            if(equipment==null && gameInfo.getCreatureById(id).getTeamId() == gameInfo.getIdTeamMortos()){
                return false;
            }
        }
        posX = xD;
        posY = yD;
        return true;
    }

    public String getImagePNG(){
        return "steve.png";
    }

}
