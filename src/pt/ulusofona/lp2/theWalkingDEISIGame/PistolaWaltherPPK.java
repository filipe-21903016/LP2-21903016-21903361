package pt.ulusofona.lp2.theWalkingDEISIGame;

public class PistolaWaltherPPK extends Equipamento {
    int bullets = 3;

    public PistolaWaltherPPK(int id, int posX, int posY) {
        super(id, 2, posX, posY);
        super.titulo = "Pistola Walther PPK";
    }


    @Override
    String getInfo() {
        return titulo + " | " + bullets;
    }

    public String getImagePNG(){
        return "pistol.png";
    }
}
