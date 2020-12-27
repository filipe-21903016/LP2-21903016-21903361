package pt.ulusofona.lp2.theWalkingDEISIGame;

public abstract class Creature {
    protected int idCriatura;
    protected int idType;
    protected String nome;
    protected int posX;
    protected int posY;
    protected int teamId;
    protected String nomeTipo;
    protected boolean dead;


    public Creature(int idCriatura,int idType, String nome, int posX, int posY) {
        this.idCriatura = idCriatura;
        this.idType = idType;
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

    public abstract boolean move(int xO,int yO,int xD, int yD);

    public abstract String getImagePNG();

}
