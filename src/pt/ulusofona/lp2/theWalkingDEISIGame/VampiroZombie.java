package pt.ulusofona.lp2.theWalkingDEISIGame;

public class VampiroZombie extends Zombie {
    public VampiroZombie(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura, 4, nome, posX, posY);
        nomeTipo="Zombie Vampiro";
    }

    public String getImagePNG() {
        return "vampire.png";
    }
}
