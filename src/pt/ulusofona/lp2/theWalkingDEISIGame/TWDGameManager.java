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
        /*Deve tentar executar uma jogada,
        considerando que (xO, yO) representa a
        origem a jogada e (xD, yD) representa o
        destino da jogada.
        Caso a jogada seja válida, deve executar a
        mesma e devolver true. Em caso
        contrário, deve devolver false.*/
        return false;
    }

    public boolean gameIsOver() {
        /*Deve devolver true caso já tenha sido
        alcançada uma das condições de paragem
        do jogo e false em caso contrário.*/
        return false;
    }

    public List<String> getAuthors() {
        /*Devolve uma lista de Strings com os
        nomes dos autores do projecto.
        Esta informação será usada para mostrar o
        conteúdo da janela que aparece ao
        carregar no botão de “Créditos”.*/
        return new ArrayList<String>();
    }

    public int getCurrentTeamId() {
        /*Deve devolver o ID da equipa que está
        activa no turno actual.*/
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
        /*Dever retornar true caso o turno actual
        corresponda a um turno diurno e false
        caso o turno actual corresponda um turno
        nocturno.*/
        return false;
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
