package pt.ulusofona.lp2.theWalkingDEISIGame;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;

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

            if(!lines.get(0).equals("+SAVED+")){
                return startGame(fich);
            }
            lines.remove(0);

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
            allLine = new StringBuffer();
            for (int i = 0; i < data.length; i++) {
                allLine.append(data[i]);
            }
            int nrHavens = Integer.parseInt(allLine.toString());
            currentLine++;

            maxLine = currentLine + nrHavens;
            for (; currentLine < maxLine; currentLine++) {
                data = lines.get(currentLine).split(" : ");
                int posX = Integer.parseInt(data[0]);
                int posY = Integer.parseInt(data[1]);
                gameInfo.addSafeHaven(new SafeHaven(posX, posY));
            }
            //Write initial game
            StringBuilder initialGame=new StringBuilder();
            for(int i=0;i<maxLine;i++){
                initialGame.append(lines.get(i)).append("\n");
            }
            gameInfo.setIntialGame(initialGame);

            //GET MOVES
            data = lines.get(currentLine).split("");
            allLine = new StringBuffer();
            for (int i = 0; i < data.length; i++) {
                allLine.append(data[i]);
            }
            int nrMoves = Integer.parseInt(allLine.toString());
            currentLine++;
            maxLine = currentLine + nrMoves;
            for (; currentLine < maxLine; currentLine++) {
                data = lines.get(currentLine).split(" : ");
                int xO = Integer.parseInt(data[0]);
                int yO = Integer.parseInt(data[1]);
                int xD = Integer.parseInt(data[2]);
                int yD = Integer.parseInt(data[3]);
                move(xO,yO,xD,yD);
            }
            scanner.close();
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public boolean saveGame(File fich) {
        try{
            FileWriter fileWriter = new FileWriter(fich);
            ArrayList<String> savedMoves = gameInfo.getSavedMoves();
            StringBuilder allGame= new StringBuilder();
            allGame.append("+SAVED+").append("\n");
            allGame.append(gameInfo.getIntialGame().toString());
            allGame.append(savedMoves.size()).append("\n");
            for(String move:savedMoves){
                allGame.append(move).append("\n");
            }
            fileWriter.write(allGame.toString());
            fileWriter.close();
            return true;
        }catch (IOException exception){
            return false;
        }
    }

    public boolean startGame(File ficheiroInicial) {
        gameInfo.reset();
        try {
            Scanner scanner = new Scanner(ficheiroInicial);
            ArrayList<String> lines = new ArrayList<>();

            //Scans all lines to list
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            gameInfo.setIntialGame(list2StringBuilder(lines));
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
            allLine = new StringBuffer();
            for (int i = 0; i < data.length; i++) {
                allLine.append(data[i]);
            }
            int nrHavens = Integer.parseInt(allLine.toString());
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
                //System.out.println(gameInfo.getNrTurno());
                gameInfo.nextTurn();
                gameInfo.saveMove(xO+" : "+yO+" : "+xD+" : "+yD);
            }
            return obtained;
        }
        return false;
    }

    public boolean gameIsOver() {
        if(gameInfo.getTurnosSemTransformacao() > gameInfo.getNrMaxTurnos()){
            return true;
        }

        for (Creature creature : gameInfo.getCreatures()) {
            if (creature.getTeamId() == gameInfo.getIdTeamVivos()){
                Vivo vivo = (Vivo) creature;
                if (!vivo.isSafe()){
                    return false;
                }
            }
        }
        return true;

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
            results.add("OS VIVOS");
            gameInfo.getCreatures().sort(Comparator.comparing(Creature::getId));
            for (Creature creature : gameInfo.getCreatures()) {
                if (creature.isVivo()) {
                    Vivo vivo = (Vivo) creature;
                    if(!vivo.isSafe()){
                        results.add(creature.getId() + " " + creature.getNome());
                    }
                }
            }
            results.add("");
            results.add("OS OUTROS");
            gameInfo.getCreatures().sort(Comparator.comparing(Creature::getId));
            for (Creature creature : gameInfo.getCreatures()) {
                if (!creature.isVivo()) {
                    results.add(creature.getId() + " (antigamente conhecido como " + creature.getNome() + ")");
                }
            }
            results.add("Num safe haven:");
            results.add("");
            results.add("OS VIVOS");
            SafeHaven.getSurvivors().sort(Comparator.comparing((Function<Creature, Integer>) Creature::getId));
            for (Vivo vivo : SafeHaven.getSurvivors()) {
                results.add(vivo.getId() + " " + vivo.getNome());
            }
            results.add("");
            results.add("Envenenados / Destruídos");
            results.add("OS VIVOS");
            gameInfo.getCreatures().sort(Comparator.comparing(Creature::getId));
            for (Creature creature : gameInfo.getGraveyard()) {
                if (creature.isVivo()) {
                    results.add(creature.getId() + " " + creature.getNome());
                }
            }
            results.add("");
            results.add("OS OUTROS");
            gameInfo.getCreatures().sort(Comparator.comparing(Creature::getId));
            for (Creature creature : gameInfo.getGraveyard()) {
                if (!creature.isVivo()) {
                    results.add(creature.getId() + " (antigamente conhecido como " + creature.getNome() + ")");
                }
            }
            results.add("");
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
            //System.out.print("Null pointer exception:" + equipmentId);
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
            if(creature.isEquiped()){
                return creature.getEquipment().getId();
            }else{
                return 0;
            }
        } catch (NullPointerException | ClassCastException exception) {
            return 0;
        }
    }

    public String[] popCultureExtravaganza() {
        String[] resultado = new String[14];
        resultado[0] = "Resident Evil";
        resultado[1] = "Evil Dead";
        resultado[2] = "I Am Legend";
        resultado[3] = "I Am Legend";
        resultado[4] = "Adventure Time";
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

    private StringBuilder list2StringBuilder(ArrayList<String> lines){
        StringBuilder initialGame = new StringBuilder();
        for(String line: lines) {
            initialGame.append(line).append("\n");
        }
        return initialGame;
    }

}
