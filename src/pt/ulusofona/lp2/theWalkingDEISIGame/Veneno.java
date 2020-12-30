package pt.ulusofona.lp2.theWalkingDEISIGame;

public class Veneno extends Equipamento {
    boolean used;
    public Veneno(int id, int posX, int posY) {
        super(id, 8, posX, posY);
        super.titulo = "Veneno";
        super.defensive=true;
    }

    public String getImagePNG(){
        return "poison.png";
    }

    @Override
    public boolean use() {
        if(!used){
            used=true;
            super.defensive=false;
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        return used;
    }

    @Override
    String getInfo() {
        if (used) {
            return titulo + " | 0";
        }else{
            return titulo + " | 1";
        }
    }


}
