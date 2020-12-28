package pt.ulusofona.lp2.theWalkingDEISIGame;

public class EstacaDeMadeira extends Equipamento {
    public EstacaDeMadeira(int id, int posX, int posY) {
        super(id, 6, posX, posY);
        super.titulo = "Estaca de Madeira";
        super.offensive = true;
    }

    public String getImagePNG(){
        return "steak.png";
    }

}
