package pt.ulusofona.lp2.theWalkingDEISIGame;

public class RevistaMaria extends Equipamento {
    public RevistaMaria(int id, int posX, int posY) {
        super(id, 4, posX, posY);
        super.titulo = "Revista Maria";
        super.defensive = true;
    }

    public String getImagePNG(){
        return "rolled_magazine.png";
    }


}
