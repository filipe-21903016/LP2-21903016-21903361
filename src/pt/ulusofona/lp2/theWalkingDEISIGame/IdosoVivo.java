package pt.ulusofona.lp2.theWalkingDEISIGame;

public class IdosoVivo extends Vivo {
    public IdosoVivo(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura, 8, nome, posX, posY);
        nomeTipo="Idoso (Vivo)";
    }

    public String getImagePNG() {
        return "oldMan.png";
    }

}
