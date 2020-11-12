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

    public void addCreature(int idCriatura, int idType
            , String name, int posX, int posY){
        if(idType==0){
            zombies.add(new Zombie(idCriatura,name,posX,posY));
        }else{
            humans.add(new Humano(idCriatura,name,posX,posY));
        }
    }

    public void addEquipment(int id, int idTipo, int posX, int posY){
        equipments.add(new Equipamento(id,idTipo,posX,posY));
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
