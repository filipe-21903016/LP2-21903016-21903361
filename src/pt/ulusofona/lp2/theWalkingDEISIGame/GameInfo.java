package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.HashMap;

public class GameInfo {
    private final int nrMaxTurnos = 12;
    private final int idTeamVivos = 10;
    private final int idTeamMortos = 20;
    private int nrTurno;
    private int nrLines;
    private int nrColumns;
    private int currentTeamID;
    private int firstTeamId;
    private int turnosSemTransformacao=0;
    private ArrayList<Creature> creatures = new ArrayList<>();
    private ArrayList<Equipamento> equipments = new ArrayList<>();
    private ArrayList<SafeHaven> safeHavenDoors = new ArrayList<>();
    private HashMap<Integer, Creature> creatureHashMap = new HashMap<>();
    private HashMap<Integer, Equipamento> equipamentoHashMap = new HashMap<>();
    private ArrayList<Creature> graveyard = new ArrayList<>();
    private ArrayList<Vivo> poisonedVivos = new ArrayList<>();


    public void reset(){
        nrTurno=0;
        nrLines=0;
        nrColumns=0;
        currentTeamID=0;
        firstTeamId =0;
        turnosSemTransformacao=0;
        creatures = new ArrayList<>();
        equipments = new ArrayList<>();
        safeHavenDoors = new ArrayList<>();
        SafeHaven.resetSurvivors();
        creatureHashMap = new HashMap<>();
        equipamentoHashMap = new HashMap<>();
        graveyard = new ArrayList<>();
        poisonedVivos = new ArrayList<>();
    }


    private GameInfo() {
    }

    public static GameInfo instance = new GameInfo();

    public static GameInfo getInstance() {
        return instance;
    }
    //Getters

    public int getNrMaxTurnos() {
        return nrMaxTurnos;
    }

    public int getTurnosSemTransformacao() {
        return turnosSemTransformacao;
    }

    public HashMap<Integer, Equipamento> getEquipamentoHashMap() {
        return equipamentoHashMap;
    }

    public Creature getCreatureById(int id) {
        return creatureHashMap.get(id);
    }

    public int getFirstTeamId() {
        return firstTeamId;
    }

    public void setFirstTeamId(int firstTeamId) {
        this.firstTeamId = firstTeamId;
    }

    public int getElementId(int x, int y) {
        for (SafeHaven sf : safeHavenDoors) {
            if (sf.getPosY() == y && sf.getPosX() == x) {
                return 0;
            }
        }

        for (Creature c : creatures) {
            if (c.getPosY() == y && c.getPosX() == x) {
                return c.getId();
            }
        }

        for (Equipamento equipamento : equipments) {
            if (equipamento.getPosY() == y && equipamento.getPosX() == x) {
                return equipamento.getId();
            }
        }

        return 0;
    }

    public void bury(Creature creature){
        graveyard.add(creature);
        creature.setDead();
    }

    public Equipamento getEquipmentById(int id) {
        return equipamentoHashMap.get(id);
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

    public boolean isDoorToSafeHaven(int x, int y) {
        for (SafeHaven sf :safeHavenDoors) {
            if (sf.equals(new SafeHaven(x, y))) {
                return true;
            }
        }
        return false;
    }

    public HashMap<Integer, Creature> getCreatureHashMap() {
        return creatureHashMap;
    }

    /* public ArrayList<Zombie> getZombies() {
        return zombies;
    }*/

    /* public ArrayList<Vivo> getHumans() {
        return humans;
    }*/
    public boolean isDay(){
        return nrTurno == 0 || nrTurno == 1 ||
                nrTurno == 4
                || nrTurno == 5 || nrTurno == 8 ||
                nrTurno == 9 || nrTurno == 12;
    }

    public ArrayList<Equipamento> getEquipments() {
        return equipments;
    }

    public ArrayList<SafeHaven> getSafeHavens() {
        return safeHavenDoors;
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

    public ArrayList<Creature> getGraveyard() {
        return graveyard;
    }

    //Setters

    public void setNrLines(int nrLines) {
        this.nrLines = nrLines;
    }

    public void setNrColumns(int nrColumns) {
        this.nrColumns = nrColumns;
    }

    public void setCurrentTeamID(int id) {
        currentTeamID = id;
    }

    //Others

    public void addCreature(Creature creature) {
        creatures.add(creature);
        if (!creatureHashMap.containsKey(creature.getId())) {
            creatureHashMap.put(creature.getId(), creature);
        }

    }

    public void addSafeHaven(SafeHaven sf) {
        this.safeHavenDoors.add(sf);
    }


    public int nextTurn() {
        ArrayList<Vivo> removed = new ArrayList<>();
        //removes from creature list
        for(Vivo vivo: poisonedVivos){
            vivo.incrementPoisenedTurn();
            if (vivo.getTurnsPoisoned()>2){
                removeCreature(vivo);
                removed.add(vivo);
            }
        }
        //removed from poisoned list
        for(Vivo v:removed){
            poisonedVivos.remove(v);
        }
        turnosSemTransformacao++;
        this.currentTeamID = (currentTeamID == idTeamVivos) ? idTeamMortos : idTeamVivos;
        return nrTurno++;
    }

    public void addEquipment(Equipamento equipamento) {
        equipments.add(equipamento);
        if (!equipamentoHashMap.containsKey(equipamento.getId())) {
            equipamentoHashMap.put(equipamento.getId(), equipamento);
        }
    }

    public void removeEquipment(Equipamento equipamento) {
        /*int index = 0;
        for (Equipamento equipamento1 : equipments) {
            if (equipamento.getId() == equipamento1.getId()) {
                break;
            }
            index++;
        }
        //remove from list
        equipments.remove(index);*/
        //remove from hashmap
        //equipamentoHashMap.remove(equipamento.getId());
        equipments.remove(equipamento);
    }

    public void removeCreature(Creature creature) {
        creatures.remove(creature);
        creatureHashMap.remove(creature.getId());
        graveyard.add(creature);
    }

    public int getTeamIdByCreatureId(int id){
        return creatureHashMap.get(id).getTeamId();
    }


    public void addPoisoned(Vivo vivo) {
        poisonedVivos.add(vivo);
    }

    public void removePoisoned(Vivo vivo){
        poisonedVivos.remove(vivo);
    }

    /*public int roundsWithoutTransformation(){
        int result = 0;
        for (Creature creature : getCreatures()){
            for (int i = 1; i <13; i++){
                if (creature.getTeamId() == nextTurn()){
                    result++;
                }
                else {
                    result = 0;
                }
            }
        }
        return result;
    }*/

    public void setTurnosSemTransformacao(int turnosSemTransformacao) {
        this.turnosSemTransformacao = turnosSemTransformacao;
    }
}
