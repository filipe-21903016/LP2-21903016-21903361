package pt.ulusofona.lp2.theWalkingDEISIGame;

public class Antidoto extends Equipamento {
    boolean used;

    public Antidoto(int id, int posX, int posY) {
        super(id, 9, posX, posY);
        super.titulo = "Antídoto";
        super.defensive= false;
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
            uso++;
            return true;
        }
        return false;
    }

    @Override
    public String getInfo() {
        if (used) {
            return titulo + " | 0";
        }else{
            return titulo + " | 1";
        }
    }
}
