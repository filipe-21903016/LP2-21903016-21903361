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

