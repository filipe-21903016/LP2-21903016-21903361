package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.util.ArrayList;
import java.util.HashMap;

public class GameInfo {
    final int nrMaxTurnos = 12;
    final int idZombie = 0;
    final int idHumano = 1;
    final int idTeamVivos = 10;
    final int idTeamMortos = 20;
    int nrTurno;
    int nrLines;
    int nrColumns;
    int firstTeamID;
    int currentTeamID;
    //ArrayList<Zombie> zombies = new ArrayList<>();
    //ArrayList<Vivo> humans = new ArrayList<>();
    ArrayList<Creature> creatures = new ArrayList<>();
    ArrayList<Equipamento> equipments = new ArrayList<>();
    ArrayList<SafeHaven> safeHavens = new ArrayList<>();


    //HashMap<Integer, Zombie> zombieHashMap = new HashMap<>();
    //HashMap<Integer, Vivo> humanoHashMap = new HashMap<>();
    HashMap<Integer, Creature> creatureHashMap = new HashMap<>();
    HashMap<Integer, Equipamento> equipamentoHashMap = new HashMap<>();


    //Getters

    public int getNrMaxTurnos() {
        return nrMaxTurnos;
    }

    /*
    public HashMap<Integer, Zombie> getZombieHashMap() {
        return zombieHashMap;
    }
    */
    /*
    public HashMap<Integer, Vivo> getHumanoHashMap() {
        return humanoHashMap;
    }
    */

    public HashMap<Integer, Equipamento> getEquipamentoHashMap() {
        return equipamentoHashMap;
    }

    Equipamento getEquipmentById(int id){
        return equipamentoHashMap.get(id);
    }

    Creature getCreatureById(int id){
        return creatureHashMap.get(id);
    }


    /*
    Vivo getVivoById(int id) {
        return humanoHashMap.get(id);
    }
    */
    /*
    Zombie getZombieById(int id) {
        return zombieHashMap.get(id);
    }
     */


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

    /*public ArrayList<Zombie> getZombies() {
        return zombies;
    }*/

    /*public ArrayList<Vivo> getHumans() {
        return humans;
    }*/

    public ArrayList<Equipamento> getEquipments() {
        return equipments;
    }

    public ArrayList<SafeHaven> getSafeHavens() {
        return safeHavens;
    }

    public int getCurrentTeamID() {
        return currentTeamID;
    }

    public int getIdTeamVivos() {
        return idTeamVivos;
    }

    public int getIdTeamMortos() {
        return idTeamMortos;
    }

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

    //Setters

    public void setNrLines(int nrLines) {
        this.nrLines = nrLines;
    }

    public void setNrColumns(int nrColumns) {
        this.nrColumns = nrColumns;
    }

    public void setFirstTeamID(int firstTeamID) {
        this.firstTeamID = firstTeamID;
    }

    public void setCurrentTeamID(int id) {
        currentTeamID = id;
    }

    //Others
    
    /*public void addCreature(int idCriatura, int idType
            , String name, int posX, int posY) {
        if (humanoHashMap.containsKey(idCriatura) || zombieHashMap.containsKey(idCriatura)) {
            return;
        }

        if (idType == idZombie) {
            Zombie zombie = new Zombie(idCriatura, name, posX, posY);
            zombies.add(zombie);
            zombieHashMap.put(zombie.getId(), zombie);
        } else {
            Humano human = new Humano(idCriatura, name, posX, posY);
            humans.add(human);
            humanoHashMap.put(human.getId(), human);
        }
    }*/

    public void addCreature(Creature creature){
        creatures.add(creature);
        if(!creatureHashMap.containsKey(creature.getId())){
            creatureHashMap.put(creature.getId(),creature);
        }

    }

    public void addSafeHaven(SafeHaven sf){
        this.safeHavens.add(sf);
    }


    public void addEquipment(int id, int idTipo, int posX, int posY) {
        if (equipamentoHashMap.containsKey(id)) {
            return;
        }
        Equipamento equipamento = new Equipamento(id, idTipo, posX, posY);
        equipments.add(equipamento);
        equipamentoHashMap.put(equipamento.getId(), equipamento);
    }

    public int nextTurn() {
        this.currentTeamID = (currentTeamID == idTeamVivos) ? idTeamMortos : idTeamVivos;
        return nrTurno++;
    }

    public void addEquipment(Equipamento equipamento) {
        equipments.add(equipamento);
        equipamentoHashMap.put(equipamento.getId(), equipamento);
    }

    void removeEquipment(Equipamento equipamento) {
        int index = 0;
        for (Equipamento equipamento1 : equipments) {
            if (equipamento.getId() == equipamento1.getId()) {
                break;
            }
            index++;
        }
        equipments.remove(index);
        equipamentoHashMap.remove(equipamento.getId());
    }


}
