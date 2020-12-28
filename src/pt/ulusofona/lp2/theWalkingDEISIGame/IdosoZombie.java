package pt.ulusofona.lp2.theWalkingDEISIGame;

public class IdosoZombie extends Zombie {
    public IdosoZombie(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura,3, nome, posX, posY);
        nomeTipo="Idoso (Zombie)";
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

    public String getImagePNG(){
        return "oldZombie.png";
    }



}
