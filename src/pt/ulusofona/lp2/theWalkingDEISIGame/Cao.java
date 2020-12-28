package pt.ulusofona.lp2.theWalkingDEISIGame;

public class Cao extends Vivo {
    public Cao(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura,9,nome, posX, posY);
        nomeTipo="Cão";
    }

    public String getImagePNG(){
        return "dog.png";
    }

}
