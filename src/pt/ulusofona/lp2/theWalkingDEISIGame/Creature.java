package pt.ulusofona.lp2.theWalkingDEISIGame;

public class Creature {
    protected int idCriatura;
    protected String nome;
    protected int posX;
    protected int posY;

    public Creature(int idCriatura, String nome, int posX, int posY) {
        this.idCriatura = idCriatura;
        this.nome = nome;
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
