package pt.ulusofona.lp2.theWalkingDEISIGame;

public class Zombie {
    String nome;
    String nomeEquipa = "Os Outros";
    int idCriatura;
    int posX;
    int posY;
    int equipmentsDestroyed;


    public Zombie(int idCriatura, String nome, int posX, int posY) {
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

    void destroyEquiment() {
        this.equipmentsDestroyed++;
    }

    public int getId() {
        return this.idCriatura;
    }

    public String getImagePNG() {
        return "zombie.png";
    }

    public String toString() {
        return idCriatura + " | Zombie | " + nomeEquipa + " | " + nome
                + " " + equipmentsDestroyed + " @ (" + posX + ", " + posY + ")";
    }

    public void setCoordinates(int x, int y) {
        this.posX = x;
        this.posY = y;
    }
}
