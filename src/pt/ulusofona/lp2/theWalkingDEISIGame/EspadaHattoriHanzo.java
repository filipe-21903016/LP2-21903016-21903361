package pt.ulusofona.lp2.theWalkingDEISIGame;

public class EspadaHattoriHanzo extends Equipamento {
    public EspadaHattoriHanzo(int id, int posX, int posY) {
        super(id, 1, posX, posY);
        super.titulo = "Espada Hattori Hanzo";
    }

    public String getImagePNG(){
        return "equipment.png";
    }
}
