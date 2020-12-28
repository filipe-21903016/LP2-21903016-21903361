package pt.ulusofona.lp2.theWalkingDEISIGame;

public class GarrafaDeLixivia extends Equipamento {
    int litros;

    public GarrafaDeLixivia(int id, int posX, int posY) {
        super(id, 7, posX, posY);
        super.titulo = "Garrafa de Lixívia";
        this.litros = 1;
        super.defensive = true;
    }

    @Override
    String getInfo() {
        int uses = (int) (litros/0.3);
        return titulo + " | (" + litros +" litro) | " + uses;
    }

    public String getImagePNG(){
        return "bleach.png";
    }
}
