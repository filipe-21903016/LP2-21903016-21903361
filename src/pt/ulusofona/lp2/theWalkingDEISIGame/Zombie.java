package pt.ulusofona.lp2.theWalkingDEISIGame;

abstract class Zombie extends Creature {
    protected String nomeEquipa = "Os Outros";
    protected int equipmentsDestroyed;

    public Zombie(int idCriatura, int idType,String nome, int posX, int posY) {
        super(idCriatura,idType, nome, posX, posY);
        teamId=20;
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
