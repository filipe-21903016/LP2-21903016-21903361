package pt.ulusofona.lp2.theWalkingDEISIGame;

abstract class Zombie extends Creature{
    private String nomeEquipa = "Os Outros";
    private int equipmentsDestroyed;

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

    abstract boolean move();

}
