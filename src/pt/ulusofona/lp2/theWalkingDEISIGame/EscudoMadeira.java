package pt.ulusofona.lp2.theWalkingDEISIGame;

public class EscudoMadeira extends Equipamento {
    public EscudoMadeira(int id, int posX, int posY) {
        super(id, 0, posX, posY);
        super.titulo = "Escudo de Madeira";
    }

    @Override
    String getInfo() {
        return titulo + " | " + uses;
    }

    public String getImagePNG(){
        return "shield.png";
    }
}
