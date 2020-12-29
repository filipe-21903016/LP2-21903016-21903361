package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.util.Objects;

abstract class Vivo extends Creature {
    protected Equipamento equipment;
    protected String nomeEquipa = "Os Vivos";
    protected boolean safe;
    protected int turnsPoisoned = 0;

    public Vivo(int idCriatura, int idType, String nome, int posX, int posY) {
        super(idCriatura, idType, nome, posX, posY);
        teamId = 10;
    }

    @Override
    public boolean move(int xO, int yO, int xD, int yD) {
        if (!isValidMove(xO, yO, xD, yD)) {
            return false;
        }

        GameInfo gameInfo = GameInfo.getInstance();
        int id = gameInfo.getElementId(xD, yD);


        if (id < 0) { //entao é id de equipamento
            if (equipment != null) {
                gameInfo.addEquipment(dropEquipment());
            }
            Equipamento equipamento = gameInfo.getEquipmentById(id);
            if(!this.isPoisoned() && equipamento.getIdTipo() ==9){ //TODO change this
                return false;
            }
            pickEquipment(equipamento);
            gameInfo.removeEquipment(equipamento);
        }
        if (id == 0 && gameInfo.isDoorToSafeHaven(xD, yD)) {
            enterSafeHaven();
        }
        if (id > 0) {
            //humano sem equipamento nao se pode mover para cima de zombie
            if (equipment == null) {
                return false;
            }
            //caso humano tenha equipamento ofensivo pode se mover e matar o zombie
            if (equipment.isOffensive()) {
                Creature target = gameInfo.getCreatureById(id);
                if(this.idType==5 && target.getIdType()!=0){
                    return false;
                }
                if (this.equipment.getIdTipo() != 6 && target.getIdType() == 4) { //vampires only dies to wooden stake
                    return false;
                }
                if (!this.combat(target)) {
                    return false;
                }
            }/*else{
                return false;
            }*/
        }
        posX = xD;
        posY = yD;
        return true;
    }

    public boolean combat(Creature creature) {

        if (this.equipment.use()) {
            GameInfo gameInfo = GameInfo.getInstance();
            gameInfo.removeCreature(creature);
            return true;
        }
        return false;
    }

    void pickEquipment(Equipamento equipamento) {
        //escudo madeira apanhado por militar
        if (this.idType == 7 && equipamento.getIdTipo() == 0) {
            EscudoMadeira escudoMadeira = (EscudoMadeira) equipamento;
            if (!escudoMadeira.isBuffed()) {
                escudoMadeira.militaryBuff();
            }
        }
        if (equipamento.getIdTipo() == 8) {
            Veneno veneno = (Veneno) equipamento;
            if (!veneno.isEmpty()) {
                veneno.use();
                GameInfo.getInstance().addPoisoned(this);
            }
        }

        if(equipamento.getIdTipo() == 9){
            Antidoto antidoto = (Antidoto) equipamento;
            this.turnsPoisoned =0;
            GameInfo.getInstance().removePoisoned(this);
        }

        this.equipment = equipamento;
        equipamento.setPicked();
        equipamentos++;
    }

    Equipamento dropEquipment() {
        Equipamento currentEquipment = this.equipment;
        this.equipment = null;
        currentEquipment.setPosX(this.posX);
        currentEquipment.setPosY(this.posY);
        currentEquipment.setDropped();
        return currentEquipment;
    }

    public void enterSafeHaven() {
        this.safe = true;
        SafeHaven.addSurvivor(this);
    }

    public Equipamento getEquipment() {
        return equipment;
    }

    public String getImagePNG() {
        return "steve.png";
    }

    public int getTeamId() {
        return teamId;
    }

    @Override
    public String toString() {
        if (safe) {
            return idCriatura + " | " + nomeTipo + " | " + nomeEquipa + " | " + nome
                    + " " + equipamentos + " @ A salvo";
        }
        if (dead) {
            return idCriatura + " | " + nomeTipo + " | " + nomeEquipa + " | " + nome
                    + " " + equipamentos + " @ RIP";
        }
        return idCriatura + " | " + nomeTipo + " | " + nomeEquipa + " | " + nome
                + " " + equipamentos + " @ (" + posX + ", " + posY + ")";
    }


    public boolean isEquiped() {
        return equipment != null;
    }

    public void destroyEquipment() {
        equipment = null;
    }

    public void turn() {
        GameInfo gameInfo = GameInfo.getInstance();
        Creature zombie = CreatureFactory.makeCreature(this.getId(), this.idType - 5, this.getNome(),
                this.getPosX(), this.getPosY());
        gameInfo.removeCreature(this);
        gameInfo.addCreature(zombie);
        gameInfo.setTurnosSemTransformacao(0);
    }

    public void incrementPoisenedTurn(){
        turnsPoisoned++;
    }

    public int getTurnsPoisoned() {
        return turnsPoisoned;
    }

    public boolean isPoisoned(){
        return turnsPoisoned>0;
    }


    /*
    public boolean canDefend(Zombie zombie){
        if(zombie.idType != 3 && equipment.getIdTipo()==4){
            //revista maria apenas defende ataques de zombie idoso
            return false;
        }
        if(equipment.getIdTipo() == 5 && zombie.idType != 4){
            //cabeca de alho so defende contra vampiros
            return false;
        }
        if(equipment.getIdTipo()==8 && !this.isPoisoned()){
            return false;
        }
        if (equipment.getIdTipo()==9){
            return false;
        }
    }*/

}

