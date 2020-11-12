package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class GameInfo {
    int nrLines;
    int nrColumns;
    int firstTeamID; // ID of first team playing
    //int nrEquipments; // number of equipments
    //int nrCreatures; // Number of creatures in game (Humans/Zombies)
    ArrayList<Zombie> zombies = new ArrayList<>();
    ArrayList<Humano> humans = new ArrayList<>();
    ArrayList<Equipamento> equipments = new ArrayList<>();

    public void setNrLines(int nrLines) {
        this.nrLines = nrLines;
    }

    public void setNrColumns(int nrColumns) {
        this.nrColumns = nrColumns;
    }

    public void setFirstTeamID(int firstTeamID) {
        this.firstTeamID = firstTeamID;
    }

    public void setZombies(ArrayList<Zombie> zombies) {
        this.zombies = zombies;
    }

    public void setHumans(ArrayList<Humano> humans) {
        this.humans = humans;
    }

    public void setEquipments(ArrayList<Equipamento> equipments) {
        this.equipments = equipments;
    }

    public int getNrLines() {
        return nrLines;
    }

    public int getNrColumns() {
        return nrColumns;
    }

    public int getFirstTeamID() {
        return firstTeamID;
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public ArrayList<Humano> getHumans() {
        return humans;
    }

    public ArrayList<Equipamento> getEquipments() {
        return equipments;
    }
}
