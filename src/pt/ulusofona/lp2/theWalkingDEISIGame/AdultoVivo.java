package pt.ulusofona.lp2.theWalkingDEISIGame;

public class AdultoVivo extends Vivo {
    public AdultoVivo(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura,6, nome, posX, posY);
        nomeTipo="Adulto (Vivo)";
    }
    public String getImagePNG(){
        return "steve.png";
    }

}
