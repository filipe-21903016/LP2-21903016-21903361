package pt.ulusofona.lp2.theWalkingDEISIGame;

public class GarrafaDeLixivia extends Equipamento {
    double litros;

    public GarrafaDeLixivia(int id, int posX, int posY) {
        super(id, 7, posX, posY);
        super.titulo = "Garrafa de Lixívia";
        this.litros = 1.0;
    }

    @Override
    String getInfo() {
        return titulo + " | " + litros;
    }

    public String getImagePNG(){
        return "bleach.png";
    }
}
