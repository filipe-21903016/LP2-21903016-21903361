package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.io.SyncFailedException;

abstract class Vivo extends Creature {
    protected Equipamento equipment;
    protected String nomeEquipa = "Os Vivos";
    protected boolean safe;

    public Vivo(int idCriatura, int idType, String nome, int posX, int posY) {
        super(idCriatura, idType, nome, posX, posY);
        teamId = 10;
    }

    void pickEquipment(Equipamento equipamento) {
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

    public void enterSafeHaven(){
        this.safe=true;
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
        if(safe){
            return idCriatura + " | "+ nomeTipo +" | " + nomeEquipa + " | " + nome
                    + " " + equipamentos + " @ A salvo";
        }
        if(dead){
            return idCriatura + " | "+ nomeTipo +" | " + nomeEquipa + " | " + nome
                    + " " + equipamentos + " @ RIP";
        }
        return idCriatura + " | "+ nomeTipo +" | " + nomeEquipa + " | " + nome
                + " " + equipamentos + " @ (" + posX + ", " + posY + ")";
    }


    public boolean isEquiped() {
        return equipment!=null;
    }





}

