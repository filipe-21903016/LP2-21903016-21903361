package pt.ulusofona.lp2.theWalkingDEISIGame;

public abstract class Creature {
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

    public abstract boolean isValidMove(int xO, int yO, int xD, int yD);

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

    public abstract boolean move(int xD, int yD);

    public abstract String getImagePNG();
}
