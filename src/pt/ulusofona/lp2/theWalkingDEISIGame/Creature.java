package pt.ulusofona.lp2.theWalkingDEISIGame;

public class Creature {
    String nome;
    int idCriatura;
    int posX;
    int posY;

    public Creature(String nome, int idCriatura, int posX, int posY) {
        this.nome = nome;
        this.idCriatura = idCriatura;
        this.posX = posX;
        this.posY = posY;
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

    public void setCoordinates(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

}
