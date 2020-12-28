package pt.ulusofona.lp2.theWalkingDEISIGame;

public class MilitarVivo extends Vivo {
    public MilitarVivo(int idCriatura,String nome, int posX, int posY) {
        super(idCriatura,7, nome, posX, posY);
        nomeTipo="Militar (Vivo)";
    }

    public String getImagePNG(){
        return "soldier.png";
    }

}
