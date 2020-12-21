package pt.ulusofona.lp2.theWalkingDEISIGame;



public class Humano extends Creature{
    Equipamento equipment;
    String nomeEquipa = "Os Vivos";
    int pickedEquipments;

    public Humano(int idCriatura, String nome, int posX, int posY) {
        super(nome, idCriatura, posX, posY);
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
