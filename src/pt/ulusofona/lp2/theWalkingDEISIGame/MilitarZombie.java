package pt.ulusofona.lp2.theWalkingDEISIGame;

public class MilitarZombie extends Zombie {
    public MilitarZombie(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura,2, nome, posX, posY);
        nomeTipo="Militar (Zombie)";
    }

    public String getImagePNG(){
        return "zombieSoldier.png";
    }

}
