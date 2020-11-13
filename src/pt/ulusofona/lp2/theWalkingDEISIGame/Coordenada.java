package pt.ulusofona.lp2.theWalkingDEISIGame;

import sun.reflect.generics.factory.CoreReflectionFactory;

import java.util.ArrayList;

public class Coordenada {
    int x,y;


    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public Coordenada() {
    }

    public boolean isValidMove(int xD, int yD){
        //TODO CHANGE THIS FUNCTION ITS ULGY
        ArrayList<Coordenada> validCoordenates = new ArrayList<>();
        validCoordenates.add(new Coordenada(x,y));
        validCoordenates.add(new Coordenada(x,y+1));
        validCoordenates.add(new Coordenada(x,y-1));
        validCoordenates.add(new Coordenada(x+1,y));
        validCoordenates.add(new Coordenada(x-1,y));
        //TODO Check if is someone on a coordenate
        //return validCoordenates.contains(new Coordenada(xD,yD));
        //Coordenada destination = new Coordenada(xD,yD);
        for(Coordenada coordenada:validCoordenates){
            if(coordenada.x==xD && coordenada.y==yD){
                return true;
            }
        }
        return false;
    }

}
