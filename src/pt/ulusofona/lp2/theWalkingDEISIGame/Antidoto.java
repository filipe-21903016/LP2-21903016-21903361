package pt.ulusofona.lp2.theWalkingDEISIGame;

public class Antidoto extends Equipamento {
    int uses = 1 ;
    public Antidoto(int id, int posX, int posY) {
        super(id, 9, posX, posY);
        super.titulo = "Antídoto";
        super.defensive= true;
    }

    public String getImagePNG(){
        return "antidote.png";
    }

    public boolean isEmpty(){
        return uses==0;
    }
}
