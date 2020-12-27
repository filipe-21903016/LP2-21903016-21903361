package pt.ulusofona.lp2.theWalkingDEISIGame;

public abstract class Creature {
    protected int idCriatura;
    protected int idType;
    protected String nome;
    protected int posX;
    protected int posY;
    protected int teamId;


    public Creature(int idCriatura,int idType, String nome, int posX, int posY) {
        this.idCriatura = idCriatura;
        this.idType = idType;
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

    public int getIdType() {
        return idType;
    }

    public String getNome() {
        return nome;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setCoordinates(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    public abstract boolean move(int xD, int yD);

    public abstract String getImagePNG();

    @Override
    public String toString() {
        return "Creature{" +
                "idCriatura=" + idCriatura +
                ", idType=" + idType +
                ", nome='" + nome + '\'' +
                ", posX=" + posX +
                ", posY=" + posY +
                '}';
    }
}
