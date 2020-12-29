package pt.ulusofona.lp2.theWalkingDEISIGame;

public class Veneno extends Equipamento {
    int uses = 1;
    public Veneno(int id, int posX, int posY) {
        super(id, 8, posX, posY);
        super.titulo = "Veneno";
        super.defensive=true;
    }

    public String getImagePNG(){
        return "poison.png";
    }

    public boolean isEmpty(){
        return uses==0;
    }

}
