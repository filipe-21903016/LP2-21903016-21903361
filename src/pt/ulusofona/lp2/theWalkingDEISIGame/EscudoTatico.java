package pt.ulusofona.lp2.theWalkingDEISIGame;

public class EscudoTatico extends Equipamento {
    public EscudoTatico(int id, int posX, int posY) {
        super(id, 3, posX, posY);
        super.titulo = "Escudo Táctico";
        super.defensive = true;
    }

    public String getImagePNG(){
        return "diamondShield.png";
    }
}
