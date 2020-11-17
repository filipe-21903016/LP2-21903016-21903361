package pt.ulusofona.lp2.theWalkingDEISIGame;



public class Humano {
    Equipamento equipment;
    String nome;
    String nomeEquipa = "Os Vivos";
    int idCriatura;
    int posX;
    int posY;
    int pickedEquipments;


    public Humano(int idCriatura, String nome, int posX, int posY) {
        this.idCriatura = idCriatura;
        this.nome = nome;
        this.posX = posX;
        this.posY = posY;
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

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getId() {
        return this.idCriatura;
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

    public void setCoordinates(int x, int y) {
        this.posX = x;
        this.posY = y;
    }
}
