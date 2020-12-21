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

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
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

    public String getImagePNG(){
        return "equipment.png";
    }

    public Equipamento(int id, int idTipo, int posX, int posY) {
        this.id = id;
        this.idTipo = idTipo;
        this.posX = posX;
        this.posY = posY;
    }

    public Equipamento(String titulo, int id, int idTipo, int posX, int posY) {
        this.titulo = titulo;
        this.id = id;
        this.idTipo = idTipo;
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
