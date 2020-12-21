package pt.ulusofona.lp2.theWalkingDEISIGame;

abstract class Zombie extends Creature{
    protected String nomeEquipa = "Os Outros";
    protected int equipmentsDestroyed;
    protected int teamId = 20;

    public Zombie(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura,nome, posX, posY);
    }

    void destroyEquiment() {
        this.equipmentsDestroyed++;
    }

    public String getImagePNG() {
        return "zombie.png";
    }

    public String toString() {
        return idCriatura + " | Zombie | " + nomeEquipa + " | " + nome
                + " " + equipmentsDestroyed + " @ (" + posX + ", " + posY + ")";
    }

    public abstract boolean move(int xD, int yD);

    public int getTeamId() {
        return teamId;
    }
}
