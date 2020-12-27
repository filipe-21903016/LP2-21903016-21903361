package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.util.ArrayList;

public class SafeHaven {
    private static ArrayList<Vivo> survivors = new ArrayList<>();
    private int posX;
    private int posY;


    public SafeHaven(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SafeHaven safeHaven = (SafeHaven) o;
        return posX == safeHaven.posX &&
                posY == safeHaven.posY;
    }

    public String getImagePNG() {
        return "door.png";
    }

    public static ArrayList<Vivo> getSurvivors() {
        return survivors;
    }

    public static void addSurvivor(Vivo survivor){
        survivors.add(survivor);
    }
}
