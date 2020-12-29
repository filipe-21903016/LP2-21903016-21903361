package pt.ulusofona.lp2.theWalkingDEISIGame;

public class Antidoto extends Equipamento {
    boolean used;

    public Antidoto(int id, int posX, int posY) {
        super(id, 9, posX, posY);
        super.titulo = "Antídoto";
        super.defensive= true;
    }

    public String getImagePNG(){
        return "antidote.png";
    }

    public boolean isEmpty(){
        return used;
    }

    @Override
    public boolean use() {
        if(!used){
            used=true;
            return true;
        }
        return false;
    }
}
