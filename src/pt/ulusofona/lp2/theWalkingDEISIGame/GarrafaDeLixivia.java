package pt.ulusofona.lp2.theWalkingDEISIGame;

public class GarrafaDeLixivia extends Equipamento {
    int uses=3;

    public GarrafaDeLixivia(int id, int posX, int posY) {
        super(id, 7, posX, posY);
        super.titulo = "Garrafa de Lixívia (1 litro)";
        super.defensive = true;
    }

    @Override
    String getInfo() {
        return titulo + " | " + uses;
    }

    public String getImagePNG(){
        return "bleach.png";
    }

    @Override
    public boolean use() {
        if(uses>0){
            uses-=1;
            return true;
        }
        //super.defensive=false;
        return false;
    }

    public boolean isEmpty(){
        return uses==0;
    }
}
