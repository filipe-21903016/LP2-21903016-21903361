package pt.ulusofona.lp2.theWalkingDEISIGame;

public class AdultoZombie extends Zombie {
    public AdultoZombie(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura, 1, nome, posX, posY);
        nomeTipo="Adulto (Zombie)";
    }

    public String getImagePNG(){
        return "zombie.png";
    }


}
