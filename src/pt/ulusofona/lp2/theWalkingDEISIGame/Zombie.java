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
            Vivo vivo = (Vivo) creature;
            Equipamento targetEquipment= vivo.getEquipment();
            if(vivo.getIdType()==9){ //Zombies are afraid of dogs
                return false;
            }
            if(idType==4 && targetEquipment.getIdTipo()==5){ //Vampiro nao ataca quem tem cabecas de alho
                return false;
            }
            if(!vivo.isEquiped()){
                //transformar vivo em zombie
                Creature zombie = CreatureFactory.makeCreature(vivo.getId(), vivo.idType-5, vivo.getNome(),
                        vivo.getPosX(), vivo.getPosY());
                gameInfo.removeCreature(vivo);
                gameInfo.addCreature(zombie);
                return true;
            }
            if(vivo.getEquipment().isOffensive()){
                vivo.getEquipment().use();
                gameInfo.removeCreature(this);
                return true;
            }
            this.combat(vivo);
            return true;
        }
        posX = xD;
        posY = yD;
        return true;
    }

    @Override
    public boolean combat(Creature creature) {
        Vivo target = (Vivo) creature;
        Equipamento targetEquipment= target.getEquipment();
        if(targetEquipment.use()){ //humano usa equipamento de defesa
            return false;
        }
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
