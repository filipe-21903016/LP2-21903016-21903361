package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.util.ArrayList;

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
        this.pickedEquipments = 0;
    }

    void pickEquipment(Equipamento equipamento) {
        this.equipment = equipamento;
        pickedEquipments++;

    }

    void dropEquipment(){
        Equipamento currentEquipment = this.equipment;
        this.equipment = null;
        currentEquipment.setPosX(this.posX);
        currentEquipment.setPosY(this.posY);
        GameInfo.equipments.add(currentEquipment);
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

    /*public ArrayList<Equipamento> getEquipments() {
        return equipments;
    }*/

    public Equipamento getEquipment() {
        return equipment;
    }

    public String getImagePNG() {
        return "steve.png";
    }

    public String toString() {
        /*Retorna uma String com a informação sobre a criatura.
        Sintaxe:
            “<ID> | <Tipo> | <Nome Equipa> | <Nome> <Equipamentos> @ (<x>,<y>)”
        Onde <Tipo> deve ser o nome por extenso do tipo (p.e. “Humano” ou “Zombie”).
        Onde <Equipamentos> deve ser:
            ● Se a criatura for um Humano: a quantidade de equipamentos apanhados pelo humano desde que o jogo começou;
            ● Se a criatura for um Zombie: a quantidade de equipamentos destruídos pelo zombie desde que o jogo começou*/
        return idCriatura + " | Humano | " + nomeEquipa + " | " + nome
                + " " + pickedEquipments + " @ (" + posX + ", " + posY + ")";
    }

    public void setCoordinates(int x, int y) {
        this.posX = x;
        this.posY = y;
    }
}
