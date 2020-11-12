package pt.ulusofona.lp2.theWalkingDEISIGame;

public class Equipamento {
    String titulo;
    int id;
    int idTipo;
    int posX;
    int posY;

    public Equipamento(int id, int idTipo, int posX, int posY) {
        this.id = id;
        this.idTipo = idTipo;
        this.posX = posX;
        this.posY = posY;
    }
}
