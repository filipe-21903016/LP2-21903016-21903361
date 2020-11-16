package pt.ulusofona.lp2.theWalkingDEISIGame;

public class Equipamento {
    String titulo;
    int id;
    int idTipo;
    int posX;
    int posY;

    public int getId() {
        return id;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public String getImagePNG(){return "equipment.png";}

    public Equipamento(int id, int idTipo, int posX, int posY) {
        this.id = id;
        this.idTipo = idTipo;
        this.posX = posX;
        this.posY = posY;
    }
}
