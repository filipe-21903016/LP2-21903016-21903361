package pt.ulusofona.lp2.theWalkingDEISIGame;

public class IdosoZombie extends Zombie {
    public IdosoZombie(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura,3, nome, posX, posY);
        nomeTipo="Idoso (Zombie)";
    }
    public String getImagePNG(){
        return "oldZombie.png";
    }



}
