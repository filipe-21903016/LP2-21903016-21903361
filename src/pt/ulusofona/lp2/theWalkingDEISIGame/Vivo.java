package pt.ulusofona.lp2.theWalkingDEISIGame;

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
        pickedEquipments++;
    }

    Equipamento dropEquipment() {
        Equipamento currentEquipment = this.equipment;
        this.equipment = null;
        currentEquipment.setPosX(this.posX);
        currentEquipment.setPosY(this.posY);
        return currentEquipment;
    }

    public Equipamento getEquipment() {
        return equipment;
    }

    public String getImagePNG() {
        return "steve.png";
    }

    public abstract boolean move(int xD, int yD);

    public String toString() {
        return idCriatura + " | Humano | " + nomeEquipa + " | " + nome
                + " " + pickedEquipments + " @ (" + posX + ", " + posY + ")";
    }

    public int getTeamId() {
        return teamId;
    }

    public abstract boolean isValidMove(int xO, int yO, int xD, int yD);
}

