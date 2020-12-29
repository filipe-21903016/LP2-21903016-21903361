package pt.ulusofona.lp2.theWalkingDEISIGame;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*trying to figure this out*/

public class TWDGameManager {
    public TWDGameManager() {
    }

    public GameInfo gameInfo = GameInfo.getInstance();

    public boolean loadGame(File fich) {
        gameInfo.reset();
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
            int id = Integer.parseInt(data[0] + data[1]);
            gameInfo.setCurrentTeamID(id);
            gameInfo.setFirstTeamId(id);
            currentLine++;

            //Get number of creatures and their properties
            data = lines.get(currentLine).split("");
            StringBuffer allLine = new StringBuffer();
            for (int i = 0; i < data.length; i++) {
                allLine.append(data[i]);
            }
            int nrCreatures = Integer.parseInt(allLine.toString());
            currentLine++;

            int maxLine = currentLine + nrCreatures;
            for (; currentLine < maxLine; currentLine++) {
                data = lines.get(currentLine).split(" : ");
                int idCreature = Integer.parseInt(data[0]);
                int idType = Integer.parseInt(data[1]);
                String nomeCriatura = data[2].trim();
                int posX = Integer.parseInt(data[3]);
                int posY = Integer.parseInt(data[4]);
                Creature creature = CreatureFactory.makeCreature(idCreature, idType, nomeCriatura, posX, posY);
                gameInfo.addCreature(creature);
            }

            data = lines.get(currentLine).split("");
            allLine = new StringBuffer();
            for (int i = 0; i < data.length; i++) {
                allLine.append(data[i]);
            }
            int nrEquipment = Integer.parseInt(allLine.toString());
            currentLine++;

            maxLine = currentLine + nrEquipment;
            for (; currentLine < maxLine; currentLine++) {
                data = lines.get(currentLine).split(" : ");
                int idEquipment = Integer.parseInt(data[0]);
                int idType = Integer.parseInt(data[1]);
                int posX = Integer.parseInt(data[2]);
                int posY = Integer.parseInt(data[3]);
                Equipamento equipamento = EquipmentFactory.makeEquipment(idEquipment, idType, posX, posY);
                gameInfo.addEquipment(equipamento);
            }

            data = lines.get(currentLine).split("");
            int nrHavens = Integer.parseInt(data[0]);
            currentLine++;

            maxLine = currentLine + nrHavens;
            for (; currentLine < maxLine; currentLine++) {
                data = lines.get(currentLine).split(" : ");
                int posX = Integer.parseInt(data[0]);
                int posY = Integer.parseInt(data[1]);
                gameInfo.addSafeHaven(new SafeHaven(posX, posY));
            }

            scanner.close();
            getInitialTeam();

            if (getInitialTeam() != getCurrentTeamId()) {
                return false;
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
        return gameInfo.getFirstTeamId();
    }

    public boolean isInsideBounds(int x, int y) {
        return x >= 0 && y >= 0 && y < gameInfo.getNrLines() && x < gameInfo.getNrColumns();
    }


    public boolean move(int xO, int yO, int xD, int yD) {
        //change valid moves, changes for diferent creatures
        if (!isInsideBounds(xD, yD)) {
            return false;
        }
        int idCriatura = getElementId(xO, yO);
        int idEquipment = getElementId(xD, yD);
        if (gameInfo.getCreatureHashMap().containsKey(idCriatura)) {
            Creature creature = gameInfo.getCreatureById(idCriatura);
            if (creature.getTeamId() != gameInfo.getCurrentTeamID()) {
                return false;
            }
            //System.out.println(creature);
            boolean obtained = creature.move(xO, yO, xD, yD);
            if (obtained) {
                gameInfo.nextTurn();
            }
            return obtained;
        }
        return false;
    }

    public boolean gameIsOver() {
        /*for (Creature creature : getCreatures()) {
            if ((!(creature.getIdType() == 5 && creature.getIdType() == 6 && creature.getIdType() == 7
                && creature.getIdType() == 8 && creature.getIdType() == 9)) ||
                gameInfo.getNrTurno() == gameInfo.getNrMaxTurnos()) {
                return true;
            }
        }        */
        //TODO fazer codigo
        return false;
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
        return gameInfo.getElementId(x, y);
    }

    public List<String> getGameResults() {
        ArrayList<String> results = new ArrayList<>();
        if (gameIsOver()) {
            results.add("Nr. de turnos terminados:");
            results.add(gameInfo.getNrTurno() + "");
            results.add("");
            results.add("Ainda pelo bairro:");
            results.add("");
            results.add("OS VIVOS");
            results.add("");
            for (Creature creature : gameInfo.getCreatures()) {
                if (creature.getIdType() > 4 && creature.getIdType() < 10) {
                    results.add(creature.getId() + " (antigamente conhecido como " + creature.getNome() + ")");
                }
                results.add("");
                results.add("OS OUTROS");
                results.add("");
                if (creature.getIdType() >= 0 && creature.getIdType() < 5) {
                    results.add(creature.getId() + " (antigamente conhecido como " + creature.getNome() + ")");
                }
                results.add("");
                results.add("Num Safe haven:");
                results.add("");
                results.add("OS VIVOS");
                if (isDoorToSafeHaven(creature.getPosX(), creature.getPosY())) {
                    results.add(creature.getIdType() + " " + creature.getNome());
                }
            }
            results.add("");
            results.add("Envenenados / Destruidos");
            results.add("");
            results.add("OS VIVOS");
            for (Creature creature1 : gameInfo.getGraveyard()) {
                if (creature1.getTeamId() == gameInfo.getIdTeamVivos()) {
                    results.add(creature1.getId() + " " + creature1.getNome());
                }
            }
            results.add("");
            results.add("OS OUTROS");
            for (Creature creature2 : gameInfo.getGraveyard()) {
                if (creature2.getTeamId() == gameInfo.getIdTeamMortos()) {
                    results.add(creature2.getId() + " (antigamente conhecido como " + creature2.getNome() + ")");
                }
            }
        }
        return results;
    }

    public boolean isDay() {
        return gameInfo.isDay();
    }

    public List<Creature> getCreatures() {
        return gameInfo.getCreatures();
    }

    public List<SafeHaven> getSafeHaven() {
        return gameInfo.getSafeHavens();
    }

    public List<Equipamento> getEquipments() {
        return gameInfo.getEquipments();
    }

    public int getEquipmentTypeId(int equipmentId) {
        try {
            return gameInfo.getEquipmentById(equipmentId).getIdTipo();
        } catch (NullPointerException nullPointerException) {
            System.out.print("Null pointer exception:" + equipmentId);
            return -1;
        }

    }

    public String getEquipmentInfo(int equipmentId) {
        Equipamento equipamento = gameInfo.getEquipmentById(equipmentId);
        return equipamento.getInfo();
    }

    public boolean isDoorToSafeHaven(int x, int y) {
        return gameInfo.isDoorToSafeHaven(x, y);
    }

    public int getEquipmentId(int creatureId) {
        try {
            Vivo creature = (Vivo) gameInfo.getCreatureById(creatureId);
            return creature.getEquipment().getId();
        } catch (NullPointerException | ClassCastException exception) {
            return 0;
        }
    }

    public boolean saveGame(File fich) {
        String gameDetails = "";
        try {
            FileWriter fileWriter = new FileWriter(fich);
            gameDetails += gameInfo.getNrLines() + " " + gameInfo.getNrColumns() + "\n";
            gameDetails += gameInfo.getCurrentTeamID() + "\n";
            gameDetails += gameInfo.getCreatures().size() + "\n";
            for (Creature creature : gameInfo.getCreatures()) {
                gameDetails += creature.getId() + " : " + creature.getIdType() + " : " + creature.getNome() +
                        " : " + creature.getPosX() + " : " + creature.getPosY() + "\n";
            }
            gameDetails += gameInfo.getEquipments().size() + "\n";
            for (Equipamento equipamento : gameInfo.getEquipments()) {
                gameDetails += equipamento.getId() + " : " + equipamento.getIdTipo() + " : " + equipamento.getPosX() + " : " + equipamento.getPosY() + "\n";
            }
            gameDetails += gameInfo.getSafeHavens().size() + "\n";
            for (SafeHaven safeHaven : gameInfo.getSafeHavens()) {
                gameDetails += safeHaven.getPosX() + " : " + safeHaven.getPosY() + "\n";
            }
            System.out.println(gameDetails);
            fileWriter.write(gameDetails);
            fileWriter.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String[] popCultureExtravaganza() {
        String[] resultado = new String[14];
        resultado[0] = "Resident Evil";
        resultado[1] = "Evil Dead";
        resultado[2] = "I Am Legend";
        resultado[3] = "Gremlins";
        resultado[4] = "Freaky Stories";
        resultado[5] = "The Return of the Living Dead";
        resultado[6] = "The Mandalorian";
        resultado[7] = "1996";
        resultado[8] = "Kill Bill";
        resultado[9] = "1978";
        resultado[10] = "James Bond";
        resultado[11] = "The Walking Dead";
        resultado[12] = "Chocho";
        resultado[13] = "Freddie Mercury";

        return resultado;
    }

    public List<Integer> getIdsInSafeHaven() {
        ArrayList<Integer> ids = new ArrayList<>();
        for (Vivo survivor : SafeHaven.getSurvivors()) {
            ids.add(survivor.getId());
        }
        return ids;
    }

}
