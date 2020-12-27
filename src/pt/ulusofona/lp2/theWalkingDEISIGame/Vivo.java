package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.io.SyncFailedException;

abstract class Vivo extends Creature {
    protected Equipamento equipment;
    protected String nomeEquipa = "Os Vivos";
    protected int pickedEquipments;

    public Vivo(int idCriatura, int idType, String nome, int posX, int posY) {
        super(idCriatura, idType, nome, posX, posY);
        teamId = 10;
    }

    void pickEquipment(Equipamento equipamento) {
        this.equipment = equipamento;
        equipamento.setPicked();
        pickedEquipments++;
    }

    Equipamento dropEquipment() {
        Equipamento currentEquipment = this.equipment;
        this.equipment = null;
        currentEquipment.setPosX(this.posX);
        currentEquipment.setPosY(this.posY);
        currentEquipment.setDropped();
        return currentEquipment;
    }

    public Equipamento getEquipment() {
        return equipment;
    }

    public String getImagePNG() {
        return "steve.png";
    }

    public abstract boolean move(int xD, int yD);

    public int getTeamId() {
        return teamId;
    }

    public abstract boolean isValidMove(int xO, int yO, int xD, int yD);

    public boolean isInSafeHaven(){
        for(Vivo survivor: SafeHaven.getSurvivors()){
            if(survivor.getId() == idCriatura){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return idCriatura + " | "+ nomeTipo +" | " + nomeEquipa + " | " + nome
                + " " + pickedEquipments + " @ (" + posX + ", " + posY + ")";
    }
}

