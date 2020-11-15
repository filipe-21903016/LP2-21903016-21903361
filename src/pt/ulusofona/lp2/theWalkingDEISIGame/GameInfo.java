package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.zip.ZipOutputStream;

public class GameInfo {
    int nrTurno;
    int nrLines;
    int nrColumns;
    int firstTeamID; // ID of first team playing
    //int nrEquipments; // number of equipments
    //int nrCreatures; // Number of creatures in game (Humans/Zombies)
    ArrayList<Zombie> zombies = new ArrayList<>();
    ArrayList<Humano> humans = new ArrayList<>();
    ArrayList<Equipamento> equipments = new ArrayList<>();
    HashMap<Integer,Zombie> zombieHashMap= new HashMap<>();
    HashMap<Integer,Humano> humanoHashMap= new HashMap<>();
    HashMap<Integer,Equipamento> equipamentoHashMap= new HashMap<>();

    Humano getHumanById(int id){
        return humanoHashMap.get(id);
    }
    Zombie getZombieById(int id){
        return zombieHashMap.get(id);
    }
    Equipamento getEquipmentById(int id){
        return equipamentoHashMap.get(id);
    }



    boolean existsHuman(int id){
        for (Humano humano: humans){
            if(humano.getId()==id){
                return true;
            }
        }
        return false;
    }

    boolean existsZombie(int id){
        for (Zombie zombie: zombies){
            if(zombie.getId()==id){
                return true;
            }
        }
        return false;
    }

    boolean existsEquipment(int id){
        for (Equipamento equipamento: equipments){
            if(equipamento.getId()==id){
                return true;
            }
        }
        return false;
    }

    public HashMap<Integer, Zombie> getZombieHashMap() {
        return zombieHashMap;
    }

    public HashMap<Integer, Humano> getHumanoHashMap() {
        return humanoHashMap;
    }

    public HashMap<Integer, Equipamento> getEquipamentoHashMap() {
        return equipamentoHashMap;
    }

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
        if(humanoHashMap.containsKey(idCriatura) || zombieHashMap.containsKey(idCriatura)){
            return;
        }

        if(idType==0){
            Zombie zombie = new Zombie(idCriatura,name,posX,posY);
            zombies.add(zombie);
            zombieHashMap.put(zombie.getId(),zombie);
        }else{
            Humano human =new Humano(idCriatura,name,posX,posY);
            humans.add(human);
            humanoHashMap.put(human.getId(),human);
        }
    }

    public void addEquipment(int id, int idTipo, int posX, int posY){
        if(equipamentoHashMap.containsKey(id)){
            return;
        }
        Equipamento equipamento = new Equipamento(id,idTipo,posX,posY);
        equipments.add(equipamento);
        equipamentoHashMap.put(equipamento.getId(),equipamento);
    }

    public void setEquipments(ArrayList<Equipamento> equipments) {
        this.equipments = equipments;
    }

    public int getNrTurno() {
        return nrTurno;
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
