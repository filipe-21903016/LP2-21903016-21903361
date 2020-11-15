package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.io.*;
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

        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }

    public int[] getWorldSize() {
        return new int[]{gameInfo.getNrLines(), gameInfo.getNrColumns()};
    }

    public int getInitialTeam() {
        System.out.println(gameInfo.getFirstTeamID());
        return gameInfo.getFirstTeamID();
    }

    public List<Humano> getHumans() {
        return gameInfo.getHumans();
    }

    public List<Zombie> getZombies() {
        return gameInfo.getZombies();
    }

    public boolean move(int xO, int yO, int xD, int yD) {
        Coordenada origem = new Coordenada(xO,yO);
        if(!origem.isValidMove(xD,yD)){
            return false;
        }

        int idCriatura = getElementId(xO,yO);
        if(gameInfo.existsHuman(idCriatura)){
            gameInfo.getHumanById(idCriatura).setCoordinates(xD,yD);
            gameInfo.nrTurno++;
            return true;
        }
        if(gameInfo.existsZombie(idCriatura)){
            gameInfo.getZombieById(idCriatura).setCoordinates(xD,yD);
            gameInfo.nrTurno++;
            return true;
        }

        return false;
    }

    public boolean gameIsOver() {
        return gameInfo.getNrTurno() == 12;
    }

    public List<String> getAuthors() {
        ArrayList<String> creditos= new ArrayList<>();
        creditos.add("Filipe Coutinho 21903016");
        creditos.add("Tomás Neto 21903361");
        return creditos;
    }

    public int getCurrentTeamId() {
        if (gameInfo.getNrTurno() % 2 == 0){
            if (gameInfo.getFirstTeamID() == 1){
                return 0;
            }
            return 1;
        }
        if (gameInfo.getFirstTeamID() == 1){
            return 1;
        }
        return 0;
    }

    public int getElementId(int x, int y) {

        ArrayList<Humano> humans = gameInfo.getHumans();
        for(Humano humano:humans){
            if(humano.getPosY() == y && humano.getPosX()==x){
                return humano.getId();
            }
        }
        ArrayList<Zombie> zombies = gameInfo.getZombies();
        for(Zombie zombie:zombies){
            if(zombie.getPosY() == y && zombie.getPosX()==x){
                return zombie.getId();
            }
        }
        ArrayList<Equipamento> equipments = gameInfo.getEquipments();
        for(Equipamento equipamento:equipments){
            if(equipamento.getPosY() == y && equipamento.getPosX()==x){
                return equipamento.getId();
            }
        }

        return 0;
    }

    public List<String> getSurvivors() {
        /*Devolve uma lista de Strings que
        representam as criaturas sobreviventes do
        jogo, conforme descrito na secção dos
        “Resultados da execução …”.
        Este método não pode devolver null.
        Caso não calculem a informação
        respectiva, devem devolver uma lista
        vazia.*/
        return new ArrayList<String>();
    }

    public boolean isDay() {
        return gameInfo.getNrTurno() == 1 || gameInfo.getNrTurno() == 2 ||
                gameInfo.getNrTurno() == 5
                || gameInfo.getNrTurno() == 6 || gameInfo.getNrTurno() == 9 ||
                gameInfo.getNrTurno() == 10;

    }

    public boolean hasEquipment(int creatureId, int equipmentTypeId) {
        /*Deve retornar true caso a criatura
        identificada pelo 1º argumento tenha em
        sua posse um equipamento do tipo cujo ID
        for passado como 2º argumento.
        Em caso contrário, deve retornar false.*/
        return false;
    }


}
