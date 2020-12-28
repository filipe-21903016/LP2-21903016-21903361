package pt.ulusofona.lp2.theWalkingDEISIGame;

public class CriancaVivo extends Vivo {
    public CriancaVivo(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura,5, nome, posX, posY);
        nomeTipo="Criança (Vivo)";
    }

    public String getImagePNG(){
        return "baby.png";
    }

}
