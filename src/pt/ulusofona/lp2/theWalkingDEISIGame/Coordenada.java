package pt.ulusofona.lp2.theWalkingDEISIGame;


import java.util.ArrayList;

public class Coordenada {
    int x, y;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public boolean isValidMove(int xD, int yD) {
        ArrayList<Coordenada> validCoordenates = new ArrayList<>();
        validCoordenates.add(new Coordenada(x, y));
        validCoordenates.add(new Coordenada(x, y + 1));
        validCoordenates.add(new Coordenada(x, y - 1));
        validCoordenates.add(new Coordenada(x + 1, y));
        validCoordenates.add(new Coordenada(x - 1, y));
        //TODO Check if is someone on a coordenate
        for (Coordenada coordenada : validCoordenates) {
            if (coordenada.x == xD && coordenada.y == yD) {
                return true;
            }
        }
        return false;
    }

}
