package pt.ulusofona.lp2.theWalkingDEISIGame;

public class Zombie extends Creature{
    String nome;
    String nomeEquipa = "Os Outros";
    int idCriatura;
    int posX;
    int posY;
    int equipmentsDestroyed;

    public Zombie(int idCriatura, String nome, int posX, int posY) {
        super(nome, idCriatura, posX, posY);
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

}
