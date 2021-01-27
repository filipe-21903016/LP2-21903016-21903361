package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.util.Objects;

abstract class Vivo extends Creature {
    int kills;
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

        if(this.getIdType() == 8 && equipment!=null){ //Se é idoso e tem item dropa antes de se mover
            gameInfo.addEquipment(dropEquipment());
        }
        if (id == 0 && gameInfo.isDoorToSafeHaven(xD, yD)) { //Casa de destino é SafeHaven
            enterSafeHaven();
        }
        if (id < 0) { //entao é id de equipamento
            if (equipment != null) {
                gameInfo.addEquipment(dropEquipment());
            }
            Equipamento equipamento = gameInfo.getEquipmentById(id);
            if(!this.isPoisoned() && equipamento.getIdTipo() ==9){ //Se humano não esta envenenado nao pode apanhar antidoto
                return false;
            }
            pickEquipment(equipamento);
            gameInfo.removeEquipment(equipamento);
        }

        if (id > 0) {
            //humano sem equipamento nao se pode mover para cima de zombie
            if (equipment == null) {
                return false;
            }
            //caso humano tenha equipamento ofensivo pode se mover e matar o zombie
            if (equipment.isOffensive()) {
                Zombie target =(Zombie) gameInfo.getCreatureById(id);
                if(!this.combat(target)){
                    return false;
                }
            }else{ //se equipamento é defensivo humano nao pode atacar
                return false;
            }
        }
        posX = xD;
        posY = yD;
        return true;
    }

    private boolean combat(Zombie zombie){
        //retorna true se vivo ganha combate
        //retorna false se zombie ganha
        if(this.idType==5 && equipment.getIdTipo()==1 && zombie.getIdType()!=0){ //se a crianca tiver uma espada e o zombie nao for crianca nada acontece
            return false;
        }
        if (this.equipment.getIdTipo() != 6 && zombie.getIdType() == 4) { //vampires only die to wooden stake
            return false;
        }
        equipment.use();
        GameInfo.getInstance().removeCreature(zombie); //zombie morre
        kills++;
        return true;
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
            if(!antidoto.isEmpty()){
                antidoto.use();
                this.turnsPoisoned =0;
                GameInfo.getInstance().removePoisoned(this);
            }
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

    public void setEquipment(Equipamento equipment) {
        this.equipment = equipment;
    }

    public boolean isEquiped() {
        return equipment != null;
    }

    public void destroyEquipment() {
        equipment = null;
    }

    public void turn() {
        GameInfo gameInfo = GameInfo.getInstance();
        if(isEquiped()){
            gameInfo.getEquipmentTrash().add(this.equipment);
        }
        gameInfo.trasformCreature(this);
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

    public boolean isSafe() {
        return safe;
    }

    public int getKills() {
        return kills;
    }

    public void incrementKills(){
        kills++;
    }
}

