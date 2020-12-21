package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TWDGameManager {
    public TWDGameManager() {
    }

    public GameInfo gameInfo = new GameInfo(); //possibly need to remove public

    public boolean loadGame(File fich){
        try {
            Scanner scanner = new Scanner(fich);
            ArrayList<String> lines = new ArrayList<>();

            //Scans all lines to list
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            int currentLine = 0;

            String[] data;
            //Get nrColumns and nrLines
            data = lines.get(currentLine).split(" ");
            int nrLines = Integer.parseInt(data[0]);
            int nrColumns = Integer.parseInt(data[1]);
            gameInfo.setNrLines(nrLines);
            gameInfo.setNrColumns(nrColumns);
            currentLine++;

            //Get Id of starting team
            data = lines.get(currentLine).split("");
            int id = Integer.parseInt(data[0]);
            gameInfo.setFirstTeamID(id);
            gameInfo.setCurrentTeamID(id);
            currentLine++;

            //Get number of creatures and their properties
            data = lines.get(currentLine).split("");
            int nrCreatures = Integer.parseInt(data[0]);
            currentLine++;

            int maxLine = currentLine + nrCreatures;
            for (; currentLine < maxLine; currentLine++) {
                data = lines.get(currentLine).split(" : ");
                int idCreature = Integer.parseInt(data[0]);
                int idType = Integer.parseInt(data[1]);
                String nomeCriatura = data[2].trim();
                int posX = Integer.parseInt(data[3]);
                int posY = Integer.parseInt(data[4]);
                Creature creature = CreatureFactory.makeCreature(idCreature,nomeCriatura, posX, posY);
                gameInfo.addCreature(creature);
            }

            data = lines.get(currentLine).split("");
            int nrEquipment = Integer.parseInt(data[0]);
            currentLine++;

            maxLine = currentLine + nrEquipment;
            for (; currentLine < maxLine; currentLine++) {
                data = lines.get(currentLine).split(" : ");
                int idEquipment = Integer.parseInt(data[0]);
                int idType = Integer.parseInt(data[1]);
                int posX = Integer.parseInt(data[2]);
                int posY = Integer.parseInt(data[3]);
                Equipamento equipamento = EquipmentFactory.makeEquipment(idEquipment,posX,posY);
                gameInfo.addEquipment(equipamento);
            }

            data = lines.get(currentLine).split("");
            int nrHavens = Integer.parseInt(data[0]);
            currentLine++;

            maxLine = currentLine + nrHavens;
            for (; currentLine < maxLine; currentLine++){
                data = lines.get(currentLine).split(" : ");
                int posX = Integer.parseInt(data[0]);
                int posY = Integer.parseInt(data[1]);
                //TODO possivel fonte de erro
                gameInfo.addSafeHaven(new SafeHaven(posX,posY));
            }

            scanner.close();
            getInitialTeam();
            //System.out.println(gameInfo.getHumans().get(0));

            if (getInitialTeam() != getCurrentTeamId()) {
                return false; //alterei isto segundo piaza//
            }

        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }

    public boolean startGame(File ficheiroInicial) {
        return loadGame(ficheiroInicial);
    }

    public int[] getWorldSize() {
        return new int[]{gameInfo.getNrLines(), gameInfo.getNrColumns()};
    }

    public int getInitialTeam() {
        //System.out.println(gameInfo.getFirstTeamID());
        return gameInfo.getFirstTeamID();
    }


    /*
    public List<Vivo> getHumans() {
        return gameInfo.getHumans();
    }

    public List<Zombie> getZombies() {
        return gameInfo.getZombies();
    } */

    public boolean isValidMove(int xO, int yO, int xD, int yD){
        if(xD<0 || yD<0 || yD>= gameInfo.getNrLines() || xD>=gameInfo.getNrColumns()){ //Checks if coordenate is outside bounds
            return false;
        }
        for(Creature c:gameInfo.getCreatures()){
            if(c.getPosX()==xD && c.getPosY()==yD){
                return false;
            }
        }

        return (xD == xO && yD == yO + 1) || (xD == xO && yD == yO - 1)
                || (xD == xO + 1 && yD == yO) || (xD == xO - 1 && yD == yO);
    }

    public boolean move(int xO, int yO, int xD, int yD) {
        //change valid moves, changes for diferent creatures
        if(!isValidMove(xO, yO, xD, yD)){
            return false;
        }

        int idCriatura = getElementId(xO, yO);
        int idEquipment = getElementId(xD, yD);
        if(gameInfo.getCurrentTeamID() == gameInfo.getIdTeamVivos() &&
                gameInfo.creatureHashMap.containsKey(idCriatura)){
            Creature creature = gameInfo.getCreatureById(idCriatura);
            creature.move(); //NOT FINISHED
        }


        /*
        if (gameInfo.getHumanoHashMap().containsKey(idCriatura)
                && gameInfo.getCurrentTeamID() == gameInfo.getIdTeamVivos()) {

            Vivo vivo = gameInfo.getVivoById(idCriatura);
            System.out.println(vivo);
            if (idEquipment != 0) {
                Equipamento equipamento = gameInfo.getEquipamentoHashMap().get(idEquipment);
                if (vivo.getEquipment()!=null) {
                    Equipamento equipamentDroped = vivo.dropEquipment();
                    gameInfo.addEquipment(equipamentDroped); //adds the dropped equipment to structures
                }
                vivo.pickEquipment(equipamento);
                gameInfo.removeEquipment(equipamento); //removes picked item from structures
            }
            vivo.setCoordinates(xD, yD);
            System.out.println(vivo);
            gameInfo.nextTurn();
            return true;
        }
        if (gameInfo.getZombieHashMap().containsKey(idCriatura)
                && gameInfo.getCurrentTeamID()==gameInfo.getIdTeamMortos()) {

            Zombie zombie = gameInfo.getZombieById(idCriatura);
            System.out.println(zombie);
            if (idEquipment != 0) {
                Equipamento equipamento = gameInfo.getEquipamentoHashMap().get(idEquipment);
                zombie.destroyEquiment();
                gameInfo.removeEquipment(equipamento);
            }
            zombie.setCoordinates(xD, yD);
            gameInfo.nextTurn();
            System.out.println(zombie);
            return true;
        }*/
        return false;
    }

    public boolean gameIsOver() {
        return gameInfo.getNrTurno() == gameInfo.getNrMaxTurnos();
    }

    public List<String> getAuthors() {
        ArrayList<String> creditos = new ArrayList<>();
        creditos.add("Filipe Coutinho 21903016");
        creditos.add("Tomás Neto 21903361");
        return creditos;
    }

    public int getCurrentTeamId() {
        return gameInfo.getCurrentTeamID();
    }

    public int getElementId(int x, int y) {
        for(SafeHaven sf: gameInfo.getSafeHavens()){
            if(sf.getPosY() == y && sf.getPosX() == x){
                return 0;
            }
        }

        for(Creature c:gameInfo.getCreatures()){
            if(c.getPosY() == y && c.getPosX() == x){
                return c.getId();
            }
        }

        ArrayList<Equipamento> equipments = gameInfo.getEquipments();
        for (Equipamento equipamento : equipments) {
            if (equipamento.getPosY() == y && equipamento.getPosX() == x) {
                return equipamento.getId();
            }
        }

        return 0;
    }

    /*public List<String> getSurvivors() {
        ArrayList<String> survivors = new ArrayList<>();
        if (gameIsOver()) {
            survivors.add("Nr. de turnos terminados:");
            survivors.add(String.valueOf(gameInfo.getNrTurno()));
            survivors.add("");
            survivors.add("OS VIVOS\n");

            for (Vivo vivo : gameInfo.getHumans()) {
                survivors.add(vivo.idCriatura + " " + vivo.nome);
            }
            survivors.add(" ");
            survivors.add("OS OUTROS\n");

            for (Zombie zombie : gameInfo.getZombies()) {
                survivors.add(zombie.idCriatura + " (antigamente conhecido como " + zombie.nome
                        + ")");
            }
        }
        return survivors;
    }*/

    public List<String> getGameResults(){
        //TODO implement function
        return new ArrayList<>();
    }

    public boolean isDay() {
        return gameInfo.getNrTurno() == 0 || gameInfo.getNrTurno() == 1 ||
                gameInfo.getNrTurno() == 4
                || gameInfo.getNrTurno() == 5 || gameInfo.getNrTurno() == 8 ||
                gameInfo.getNrTurno() == 9 || gameInfo.getNrTurno() == 12;

    }

    public boolean hasEquipment(int creatureId, int equipmentTypeId) {
        Vivo vivo =(Vivo) gameInfo.getCreatureById(creatureId);
        if(vivo != null && vivo.getEquipment()!=null){
            return vivo.getEquipment().getIdTipo() == equipmentTypeId;
        }
        return false;
    }

    public List<Creature> getCreatures(){
        return gameInfo.getCreatures();
    }

    public int getEquipmentTypeId(int equipmentId){
        return gameInfo.getEquipmentById(equipmentId).getIdTipo();
    }

    public String getEquipmentInfo(int equipmentId){
        return ""; //TODO change
    }



}
