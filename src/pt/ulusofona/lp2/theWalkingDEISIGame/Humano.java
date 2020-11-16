package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.util.ArrayList;

public class Humano {
    ArrayList<Equipamento> equipments;
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
        this.equipments = new ArrayList<>();
    }

    void pickEquipment(Equipamento equipamento) {
        this.equipments.add(equipamento);
        pickedEquipments++;
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

    public ArrayList<Equipamento> getEquipments() {
        return equipments;
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
