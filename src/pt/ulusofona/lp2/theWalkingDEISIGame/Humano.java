package pt.ulusofona.lp2.theWalkingDEISIGame;

public class Humano extends Creature{
    private Equipamento equipment;
    private String nomeEquipa = "Os Vivos";
    private int pickedEquipments;

    public Humano(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura,nome, posX, posY);
    }

    void pickEquipment(Equipamento equipamento) {
        this.equipment = equipamento;
        pickedEquipments++;
    }

    Equipamento dropEquipment(){
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

    public String toString() {
        return idCriatura + " | Humano | " + nomeEquipa + " | " + nome
                + " " + pickedEquipments + " @ (" + posX + ", " + posY + ")";
    }
}

