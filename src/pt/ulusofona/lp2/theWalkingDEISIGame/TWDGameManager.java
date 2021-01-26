package pt.ulusofona.lp2.theWalkingDEISIGame;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

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

            /*if(!lines.get(0).equals("+SAVED+")){
                return startGame(fich);
            }*/
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
            StringBuilder initialGame = new StringBuilder();
            for (int i = 0; i < maxLine; i++) {
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
                move(xO, yO, xD, yD);
            }
            scanner.close();
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public boolean saveGame(File fich) {
        try {
            FileWriter fileWriter = new FileWriter(fich);
            ArrayList<String> savedMoves = gameInfo.getSavedMoves();
            StringBuilder allGame = new StringBuilder();
            allGame.append("+SAVED+").append("\n");
            allGame.append(gameInfo.getIntialGame().toString());
            allGame.append(savedMoves.size()).append("\n");
            for (String move : savedMoves) {
                allGame.append(move).append("\n");
            }
            fileWriter.write(allGame.toString());
            fileWriter.close();
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    public void startGame(File ficheiroInicial) throws InvalidTWDInitialFileException, FileNotFoundException {
        gameInfo.reset();

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

        ArrayList<String> tempCreatures = new ArrayList<>();

        for (; currentLine < maxLine; currentLine++) {
            //put data into tempCreature
            tempCreatures.add(lines.get(currentLine));
            data = lines.get(currentLine).split(" : ");
            int idCreature = Integer.parseInt(data[0]);
            int idType = Integer.parseInt(data[1]);
            String nomeCriatura = data[2].trim();
            int posX = Integer.parseInt(data[3]);
            int posY = Integer.parseInt(data[4]);
            Creature creature = CreatureFactory.makeCreature(idCreature, idType, nomeCriatura, posX, posY);
            gameInfo.addCreature(creature);
        }
        long count = tempCreatures.stream()
                .map(s -> s.split(" : "))
                .filter(strings -> strings.length != 5)
                .count();
        if (count > 0 || nrCreatures < 2) {
            throw new InvalidTWDInitialFileException(nrCreatures, tempCreatures);
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
                gameInfo.saveMove(xO + " : " + yO + " : " + xD + " : " + yD);
            }

            /*//TODO Remove sout
            getGameStatistics().get("tiposDeEquipamentoMaisUteis").forEach(System.out::println);
            System.out.println("");*/


            return obtained;
        }
        return false;
    }

    public boolean gameIsOver() {
        if (gameInfo.getTurnosSemTransformacao() > gameInfo.getNrMaxTurnos()) {
            return true;
        }

        for (Creature creature : gameInfo.getCreatures()) {
            if (creature.getTeamId() == gameInfo.getIdTeamVivos()) {
                Vivo vivo = (Vivo) creature;
                if (!vivo.isSafe()) {
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
            results.add("Ainda pelo bairo:");
            results.add("");
            results.add("OS VIVOS");
            gameInfo.getCreatures().sort(Comparator.comparing(Creature::getId));
            for (Creature creature : gameInfo.getCreatures()) {
                if (creature.isHumano()) {
                    Vivo vivo = (Vivo) creature;
                    if (!vivo.isSafe()) {
                        results.add(creature.getId() + " " + creature.getNome());
                    }
                }
            }
            results.add("");
            results.add("OS OUTROS");
            gameInfo.getCreatures().sort(Comparator.comparing(Creature::getId));
            for (Creature creature : gameInfo.getCreatures()) {
                if (!creature.isHumano()) {
                    results.add(creature.getId() + " (antigamente conhecido como " + creature.getNome() + ")");
                }
            }
            results.add("");
            results.add("Num safe haven:");
            results.add("");
            results.add("OS VIVOS");
            SafeHaven.getSurvivors().sort(Comparator.comparing((Function<Creature, Integer>) Creature::getId));
            for (Vivo vivo : SafeHaven.getSurvivors()) {
                results.add(vivo.getId() + " " + vivo.getNome());
            }
            results.add("");
            results.add("Envenenados / Destruidos");
            results.add("");
            results.add("OS VIVOS");
            gameInfo.getCreatures().sort(Comparator.comparing(Creature::getId));
            for (Creature creature : gameInfo.getGraveyard()) {
                if (creature.isHumano()) {
                    results.add(creature.getId() + " " + creature.getNome());
                }
            }
            results.add("");
            results.add("OS OUTROS");
            gameInfo.getCreatures().sort(Comparator.comparing(Creature::getId));
            for (Creature creature : gameInfo.getGraveyard()) {
                if (!creature.isHumano()) {
                    results.add(creature.getId() + " (antigamente conhecido como " + creature.getNome() + ")");
                }
            }
        }
        return results;
    }

    public boolean isDay() {
        return gameInfo.isDay();
    }

    public List<Creature> getCreatures() {
        ArrayList<Creature> allCreatures = new ArrayList<>();
        allCreatures.addAll(gameInfo.getCreatures());
        allCreatures.addAll(gameInfo.getGraveyard());
        allCreatures.sort(Comparator.comparing(Creature::getId));
        return allCreatures;
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
            if (creature.isEquiped()) {
                return creature.getEquipment().getId();
            } else {
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
        resultado[4] = "Dragon Ball";
        resultado[5] = "World War Z";
        resultado[6] = "Mandalorians";
        resultado[7] = "1972";
        resultado[8] = "Kill Bill";
        resultado[9] = "1978";
        resultado[10] = "Bond. James Bond.";
        resultado[11] = "Lost";
        resultado[12] = "Chocho";
        resultado[13] = "Farrokh Bulsara";

        return resultado;
    }

    public List<Integer> getIdsInSafeHaven() {
        ArrayList<Integer> ids = new ArrayList<>();
        for (Vivo survivor : SafeHaven.getSurvivors()) {
            ids.add(survivor.getId());
        }
        return ids;
    }

    private StringBuilder list2StringBuilder(ArrayList<String> lines) {
        StringBuilder initialGame = new StringBuilder();
        for (String line : lines) {
            initialGame.append(line).append("\n");
        }
        return initialGame;
    }

    public Map<String, List<String>> getGameStatistics() {
        Map<String, List<String>> map = new HashMap<>();
        //TODO
        List<String> resposta1 = gameInfo.getCreatures().stream()
                .filter(c -> !c.isHumano())
                .map(creature -> (Zombie) creature)
                .filter(zombie -> zombie.getTurnCount() > 0)
                .sorted((z1, z2) -> z2.getTurnCount() - z1.getTurnCount())
                .limit(3)
                .map(zombie -> zombie.getId() + ":" + zombie.getNome() + ":" + zombie.getTurnCount())
                .collect(Collectors.toList());
        map.put("os3ZombiesMaisTramados", resposta1);

        List<String> resposta2 = gameInfo.getCreatures().stream()
                .filter(Creature::isHumano)
                .map(creature -> (Vivo) creature)
                .filter(vivo -> vivo.getKills() > 0)
                .sorted((v1, v2) -> v2.getKills() - v1.getKills())
                .limit(3)
                .map(vivo -> vivo.getId() + ":" + vivo.getNome() + ":" + vivo.getKills())
                .collect(Collectors.toList());
        map.put("os3VivosMaisDuros", resposta2);




        List<Equipamento> picked = getCreatures().stream()
                .filter(Creature::isHumano)
                .map(c->(Vivo) c)
                .filter(Vivo::isEquiped)
                .map(Vivo::getEquipment)
                .collect(Collectors.toList());

        List<Equipamento> allEquipments = new ArrayList<>();
        allEquipments.addAll(picked);
        allEquipments.addAll(gameInfo.getEquipments());
        allEquipments.addAll(gameInfo.getEquipmentTrash());

        int[] nrmVezes = new int[11];
        allEquipments.stream()
                .forEach(e -> {
                    nrmVezes[e.getIdTipo()] += e.getUso();
                });

        List<String> resposta3 = allEquipments.stream()
                .map(Equipamento::getIdTipo)
                .distinct()
                .sorted((n1,n2) -> nrmVezes[n1] - nrmVezes[n2])
                .map(i -> i + " " + nrmVezes[i])
                .collect(toList());
        map.put("tiposDeEquipamentoMaisUteis", resposta3);

        String[] nomesCriatura = new String[]{"Criança", "Adulto", "Militar", "Idoso", "Vampiro"};
        int[] destroyedByType = new int[5];
        int[] nrCreatures = new int[5];

        gameInfo.getCreatures().stream()
                .filter(c -> !c.isHumano())
                .map(creature -> (Zombie) creature)
                .forEach(c -> {
                    destroyedByType[c.getIdType()] += c.getEquipamentos();
                    nrCreatures[c.getIdType()]++;
                });

        List<String> resposta4 = gameInfo.getCreatures().stream()
                .filter(c -> !c.isHumano())
                .map(Creature::getIdType)
                .distinct()
                .sorted(Comparator.comparing(n -> destroyedByType[(int) n])
                        .thenComparing(n -> nrCreatures[(int) n]).reversed())
                .map(n -> nomesCriatura[n] + ":" + nrCreatures[n] + ":" + destroyedByType[n])
                .collect(Collectors.toList());
        map.put("tiposDeZombieESeusEquipamentosDestruidos", resposta4);


        int size = gameInfo.getCreatures().size();
        int limit = Math.min(size, 5);

        Stream<Vivo> vivos = gameInfo.getCreatures().stream()
                .filter(Creature::isHumano)
                .filter(c->!c.isDead())
                .map(c-> (Vivo) c)
                .filter(v -> !v.isSafe());

        Stream<Zombie> zombies = gameInfo.getCreatures().stream()
                .filter(c -> !c.isDead())
                .filter(c -> !c.isHumano())
                .map(c-> (Zombie) c);

        /*List<String> resposta5 = gameInfo.getCreatures().stream()
                .sorted((c1, c2) -> c2.getEquipamentos() - c1.getEquipamentos())
                .filter(Creature::isDead)
                .map(creature -> creature.idCriatura + ":" + creature.getNome() + ":" + creature.getEquipamentos())
                .limit(limit)
                .collect(toList());*/

        List<String> resposta5 = Stream.concat(vivos,zombies)
                .sorted((c1, c2) -> c2.getEquipamentos() - c1.getEquipamentos())
                .map(creature -> creature.idCriatura + ":" + creature.getNome() + ":" + creature.getEquipamentos())
                .limit(limit)
                .collect(toList());

        map.put("criaturasMaisEquipadas", resposta5);

        return map;
    }


}
