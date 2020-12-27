package pt.ulusofona.lp2.theWalkingDEISIGame;

public class CriancaZombie extends Zombie {
    public CriancaZombie(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura,0, nome, posX, posY);
        nomeTipo="Criança (Zombie)";
    }

     private boolean isValidMove(int xO, int yO, int xD, int yD) {
        if (xO == xD && yO == yD) {
            return false;
        }
        return (xD==xO && yD <= yO +1 && yD >= yO -1) /*VERTICAL*/
                || (yD == yO && xD<= xO +1 && xD >= xO-1); /*HORIZONTAL*/
    }

    @Override
    public boolean move(int xO,int yO,int xD, int yD){
        GameInfo gameInfo = GameInfo.getInstance();
        if(!isValidMove(xO, yO, xD, yD) || gameInfo.isDoorToSafeHaven(xD,yD)){
            return false;
        }

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
        return "babyZombie.png";
    }

}
