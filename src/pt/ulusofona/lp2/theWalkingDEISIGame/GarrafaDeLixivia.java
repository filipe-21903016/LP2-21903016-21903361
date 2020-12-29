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
        if(uses==0){
            return false;
        }else{
            uses-=1;
            return true;
        }
    }
}
