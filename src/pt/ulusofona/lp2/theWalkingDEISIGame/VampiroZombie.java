package pt.ulusofona.lp2.theWalkingDEISIGame;

public class VampiroZombie extends Zombie {
    public VampiroZombie(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura, 4, nome, posX, posY);
        nomeTipo="Zombie Vampiro";
    }

    private boolean isValidMove(int xO, int yO, int xD, int yD) {
        GameInfo gameInfo = GameInfo.getInstance();
        if ((xO == xD && yO == yD) || gameInfo.isDay()) {
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
        if(id>0){
            Creature creature = gameInfo.getCreatureById(id);
            if(creature.getIdType()==9){ //cannot move into a dog
                return false;
            }
            if(creature.getTeamId() == gameInfo.getIdTeamVivos()){
                //transformar vivo em zombie
                Creature zombie = CreatureFactory.makeCreature(creature.getId(),
                        creature.idType-5, creature.getNome(),
                        creature.getPosX(), creature.getPosY());
                gameInfo.removeCreature(creature);
                gameInfo.addCreature(zombie);
                return true;
            }

        }
        posX = xD;
        posY = yD;
        return true;
    }

    public String getImagePNG() {
        return null;
    }
}
