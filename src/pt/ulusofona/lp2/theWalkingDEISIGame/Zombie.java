package pt.ulusofona.lp2.theWalkingDEISIGame;

abstract class Zombie extends Creature {
    protected String nomeEquipa = "Os Outros";

    public Zombie(int idCriatura, int idType,String nome, int posX, int posY) {
        super(idCriatura,idType, nome, posX, posY);
        teamId=20;
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
                Vivo vivo = (Vivo) creature;
                if(!vivo.isEquiped()){
                    //transformar vivo em zombie
                    Creature zombie = CreatureFactory.makeCreature(vivo.getId(),
                            vivo.idType-5, vivo.getNome(),
                            vivo.getPosX(), vivo.getPosY());
                    gameInfo.removeCreature(vivo);
                    gameInfo.addCreature(zombie);
                    return true;
                }
                //TODO code when human is equipped
                return false;
            }
        }
        posX = xD;
        posY = yD;
        return true;
    }


    void destroyEquiment(){
        this.equipamentos++;
    }

    public String getImagePNG() {
        return "zombie.png";
    }

    public int getTeamId() {
        return teamId;
    }

    @Override
    public String toString() {
        if(dead){
            return idCriatura + " | "+ nomeTipo +" | " + nomeEquipa + " | " + nome
                    + " " + equipamentos + " @ RIP";
        }
        return idCriatura + " | " + nomeTipo + " | " + nomeEquipa + " | " + nome
                + " " + equipamentos + " @ (" + posX + ", " + posY + ")";
    }
}
