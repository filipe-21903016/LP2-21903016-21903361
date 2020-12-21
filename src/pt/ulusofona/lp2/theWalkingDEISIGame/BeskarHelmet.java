package pt.ulusofona.lp2.theWalkingDEISIGame;

public class BeskarHelmet extends Equipamento {
    public BeskarHelmet(int id, int posX, int posY) {
        super(id, 10, posX, posY);
        super.titulo = "Beskar Helmet";
    }

    public String getImagePNG(){
        return "beskar_helmet.png";
    }
}

