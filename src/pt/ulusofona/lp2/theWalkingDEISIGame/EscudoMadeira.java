package pt.ulusofona.lp2.theWalkingDEISIGame;

public class EscudoMadeira extends Equipamento {
    int uses = 1;
    public EscudoMadeira(int id, int posX, int posY) {
        super(id, 0, posX, posY);
        super.titulo = "Escudo de Madeira";
        super.defensive = true;
    }

    public void setUses(int uses) {
        this.uses = uses;
    }

    @Override
    String getInfo() {
        return titulo + " | " + uses;
    }

    public String getImagePNG(){
        return "shield.png";
    }
}
