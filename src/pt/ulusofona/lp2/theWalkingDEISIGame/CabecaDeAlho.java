package pt.ulusofona.lp2.theWalkingDEISIGame;

public class CabecaDeAlho extends Equipamento {
    public CabecaDeAlho(int id, int posX, int posY) {
        super(id, 5, posX, posY);
        super.titulo = "Cabeça de Alho";
        super.defensive = true;
    }

    public String getImagePNG(){
        return "garlic.png";
    }


    @Override
    public boolean use() {
        return false;
    }
}
