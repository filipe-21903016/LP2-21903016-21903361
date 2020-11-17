package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TWDGameManager {
    public TWDGameManager() {
    }

    GameInfo gameInfo = new GameInfo();

    public boolean startGame(File ficheiroInicial) {
        try {
            Scanner scanner = new Scanner(ficheiroInicial);
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
                gameInfo.addCreature(idCreature, idType, nomeCriatura, posX, posY);
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
                gameInfo.addEquipment(idEquipment, idType, posX, posY);
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

    public int[] getWorldSize() {
        return new int[]{gameInfo.getNrLines(), gameInfo.getNrColumns()};
    }

    public int getInitialTeam() {
        //System.out.println(gameInfo.getFirstTeamID());
        return gameInfo.getFirstTeamID();
    }

    public List<Humano> getHumans() {
        return gameInfo.getHumans();
    }

    public List<Zombie> getZombies() {
        return gameInfo.getZombies();
    }

    public boolean move(int xO, int yO, int xD, int yD) {
        Coordenada origem = new Coordenada(xO, yO);
        if (!origem.isValidMove(xD, yD) || !gameInfo.isEmptySpace(xD, yD)) {
            return false;
        }

        int idCriatura = getElementId(xO, yO);
        int idEquipment = getElementId(xD, yD);

        if (gameInfo.existsHuman(idCriatura)) {
            Humano humano = gameInfo.getHumanById(idCriatura);
            System.out.println(humano); //TODO
            if (gameInfo.getCurrentTeamID() == gameInfo.ID_TEAM_MORTOS) {
                return false;
            }

            if (idEquipment != 0) {
                Equipamento equipamento = gameInfo.getEquipamentoHashMap().get(idEquipment);

                if (hasEquipment(humano.getId(), equipamento.getIdTipo())) {
                    Equipamento equipamentDroped = humano.dropEquipment();
                    gameInfo.addEquipment(equipamentDroped); //adds the dropped equipment to structures
                }
                humano.pickEquipment(equipamento);
                gameInfo.removeEquipment(equipamento); //removes picked item from structures
            }

            humano.setCoordinates(xD, yD);
            System.out.println(humano); //ToDo
            gameInfo.nextTurn();
            return true;
        }
        if (gameInfo.existsZombie(idCriatura)) {
            Zombie zombie = gameInfo.getZombieById(idCriatura);
            System.out.println(zombie); //todo
            if (gameInfo.getCurrentTeamID() == gameInfo.ID_TEAM_VIVOS) {
                return false;
            }
            if (idEquipment != 0) {
                Equipamento equipamento = gameInfo.getEquipamentoHashMap().get(idEquipment);

                zombie.destroyEquiment();
                gameInfo.removeEquipment(equipamento);
            }
            zombie.setCoordinates(xD, yD);
            gameInfo.nextTurn();
            System.out.println(zombie); //todo
            return true;
        }

        return false;
    }

    public boolean gameIsOver() {
        return gameInfo.getNrTurno() == gameInfo.NR_MAX_TURNOS;
    }

    public List<String> getAuthors() {
        ArrayList<String> creditos = new ArrayList<>();
        creditos.add("Filipe Coutinho 21903016");
        creditos.add("Tomás Neto 21903361");
        return creditos;
    }

    public int getCurrentTeamId() {
        return gameInfo.currentTeamID;
    }

    public int getElementId(int x, int y) {

        ArrayList<Humano> humans = gameInfo.getHumans();
        for (Humano humano : humans) {
            if (humano.getPosY() == y && humano.getPosX() == x) {
                return humano.getId();
            }
        }
        ArrayList<Zombie> zombies = gameInfo.getZombies();
        for (Zombie zombie : zombies) {
            if (zombie.getPosY() == y && zombie.getPosX() == x) {
                return zombie.getId();
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

    public List<String> getSurvivors() {
        ArrayList<String> survivors = new ArrayList<>();
        if (gameIsOver()) {
            survivors.add("Nr. de turnos terminados:");
            survivors.add(String.valueOf(gameInfo.getNrTurno()));
            survivors.add("");
            survivors.add("OS VIVOS\n");

            for (Humano humano : gameInfo.getHumans()) {
                survivors.add(humano.idCriatura + " " + humano.nome);
            }
            survivors.add(" ");
            survivors.add("OS OUTROS\n");

            for (Zombie zombie : gameInfo.getZombies()) {
                survivors.add(zombie.idCriatura + " (antigamente conhecido como " + zombie.nome
                        + ")");
            }
        }
        return survivors;
    }

    public boolean isDay() {
        return gameInfo.getNrTurno() == 0 || gameInfo.getNrTurno() == 1 ||
                gameInfo.getNrTurno() == 4
                || gameInfo.getNrTurno() == 5 || gameInfo.getNrTurno() == 8 ||
                gameInfo.getNrTurno() == 9 || gameInfo.getNrTurno() == 12;

    }

    public boolean hasEquipment(int creatureId, int equipmentTypeId) {
        Humano humano = gameInfo.getHumanById(creatureId);
        if(humano!= null && humano.getEquipment()!=null){
            return humano.getEquipment().getIdTipo() == equipmentTypeId;
        }
        return false;
        //alterei pq tava feio, mas assim ta igual
    }
}
