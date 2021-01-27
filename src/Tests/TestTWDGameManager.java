package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestTWDGameManager {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/testTWD.txt");

    @Test
    public void testGetCreature() throws InvalidTWDInitialFileException, FileNotFoundException  {
        gameManager.startGame(fich);
        ArrayList<Creature> expected = new ArrayList<>();
        Creature numeroUno = CreatureFactory.makeCreature(1,6,"Freddie M.",3,3);
        Creature numeroDos = CreatureFactory.makeCreature(2,6,"Jackie Chan",3,4);
        expected.add(numeroUno);
        expected.add(numeroDos);
        Assert.assertEquals(expected,gameManager.getCreatures());
    }

    @Test
    public void testGetEquipment() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        ArrayList<Equipamento> expected = new ArrayList<>();
        Equipamento numeroUno = EquipmentFactory.makeEquipment(-1,0,4,3);
        Equipamento numeroDos = EquipmentFactory.makeEquipment(-2,1,2,3);
        expected.add(numeroUno);
        expected.add(numeroDos);
        Assert.assertEquals(expected,gameManager.getEquipments());
    }

    @Test
    public void testGetWorldSize() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        int[] expected = new int[]{7,7};
        Assert.assertEquals(2,gameManager.getWorldSize().length);
        Assert.assertEquals(expected[0],gameManager.getWorldSize()[0]);
        Assert.assertEquals(expected[1],gameManager.getWorldSize()[1]);
    }

    @Test
    public void testGetInitialTeam() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        Assert.assertEquals(10,gameManager.getInitialTeam());
    }

    @Test
    public void testIsInsideBounds() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        Assert.assertFalse(gameManager.isInsideBounds(0,-1));
        Assert.assertFalse(gameManager.isInsideBounds(-1,0));
        Assert.assertFalse(gameManager.isInsideBounds(0,7));
        Assert.assertFalse(gameManager.isInsideBounds(0,7));
        Assert.assertFalse(gameManager.isInsideBounds(7,0));
        Assert.assertFalse(gameManager.isInsideBounds(7,0));
        Assert.assertTrue(gameManager.isInsideBounds(0,0));
        Assert.assertTrue(gameManager.isInsideBounds(1,1));
        Assert.assertTrue(gameManager.isInsideBounds(6,6));
    }

    @Test
    public void testIsDay() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.isDay());
    }

    @Test
    public void testGetEquipmentTypeId() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        Assert.assertEquals(0,gameManager.getEquipmentTypeId(-1));
    }

    @Test
    public void testGetEquipmentTypeId1() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        Assert.assertEquals(1,gameManager.getEquipmentTypeId(-2));
    }

    @Test
    public void testIsDoorToSafeHaven() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.isDoorToSafeHaven(6,6));
    }

    @Test
    public void noDoorToSafeHaven() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        Assert.assertFalse(gameManager.isDoorToSafeHaven(1,6));
    }

    @Test
    public void invalidNrCreatures(){
        File fich1 = new File("test-files/InvalidNumCreatures.txt");
        try{
            gameManager.startGame(fich1);
        }catch(InvalidTWDInitialFileException e){
            Assert.assertFalse(e.validNrOfCreatures());
            Assert.assertTrue(e.validCreatureDefinition());
        }catch (FileNotFoundException fileNotFoundException){
            fileNotFoundException.getLocalizedMessage();
        }
    }

    @Test
    public void invalidDefinition(){
        File fich1 = new File("test-files/InvalidDefinition.txt");
        try{
            gameManager.startGame(fich1);
        }catch(InvalidTWDInitialFileException e){
            Assert.assertTrue(e.validNrOfCreatures());
            Assert.assertFalse(e.validCreatureDefinition());
        }catch (FileNotFoundException fileNotFoundException){
            fileNotFoundException.getLocalizedMessage();
        }
    }

    @Test
    public void testFileNotFoundException(){
        File fich1 = new File("test-files/someNotFoundFile.txt");
        try{
            gameManager.startGame(fich1);
            Assert.fail();
        }catch(InvalidTWDInitialFileException invalid){
            Assert.fail();
        }catch (FileNotFoundException e){
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testQuery5(){
        File fich1 = new File("test-files/testQueries.txt");
        try{
            gameManager.startGame(fich1);
            Map<String, List<String>> startStats = gameManager.getGameStatistics();
            Assert.assertTrue(startStats.get("criaturasMaisEquipadas").contains("1:Freddie M.:0"));
            Assert.assertTrue(startStats.get("criaturasMaisEquipadas").contains("2:Paciente Zero:0"));
            Assert.assertTrue(gameManager.move(3,3,2,3));
            Assert.assertTrue(gameManager.move(3,4,2,4));
            Map<String, List<String>> midGameStats = gameManager.getGameStatistics();
            Assert.assertEquals("1:Freddie M.:1", midGameStats.get("criaturasMaisEquipadas").get(0));
            Assert.assertEquals("2:Paciente Zero:0", midGameStats.get("criaturasMaisEquipadas").get(1));
            Assert.assertTrue(gameManager.move(2,3,4,5));
            Assert.assertTrue(gameManager.move(2,4,3,5));
            Assert.assertTrue(gameManager.move(4,5,5,5));
            Assert.assertTrue(gameManager.move(3,5,3,6));
            Map<String,List<String>> finalGameStats = gameManager.getGameStatistics();
            Assert.assertEquals("2:Paciente Zero:2", finalGameStats.get("criaturasMaisEquipadas").get(0));
            Assert.assertEquals("1:Freddie M.:1", finalGameStats.get("criaturasMaisEquipadas").get(1));

        }catch (InvalidTWDInitialFileException | FileNotFoundException e){
            Assert.fail();
        }
    }
    @Test
    public void testMultipleQueries(){
        File fich1 = new File("test-files/testQueries1.txt");
        try{
            gameManager.startGame(fich1);
            Assert.assertTrue(gameManager.move(3,3,2,3)); //humano apanha espada
            Assert.assertTrue(gameManager.move(3,2,2,3)); //humano mata zombie com espada
            Assert.assertTrue(gameManager.move(5,4,4,4)); //humano2 apanha espada2
            Assert.assertTrue(gameManager.move(4,3,4,4)); //humano2 mata zombie2 com espada
            Assert.assertTrue(gameManager.move(4,4,3,5)); //humano2 apanha escudo madeira
            Assert.assertTrue(gameManager.move(3,4,3,5)); //humano2 defende ataque com escudo
            Assert.assertTrue(gameManager.move(3,5,4,6));
            Assert.assertTrue(gameManager.move(3,4,4,5));
            Assert.assertTrue(gameManager.move(2,3,2,1)); //humano mata zombie3
            Assert.assertTrue(gameManager.move(4,5,4,6)); //zombie transforma humano2
            Assert.assertTrue(gameManager.move(2,1,1,0)); //humano entra em safe haven

            Map<String, List<String>> finalStats = gameManager.getGameStatistics();
            //Testing first query
            List<String> query1 = finalStats.get("os3ZombiesMaisTramados");
            Assert.assertTrue(query1.contains("2:Paciente Zero:1"));
            Assert.assertEquals(1, query1.size());
            //Testing second query
            List<String> query2 = finalStats.get("os3VivosMaisDuros");
            Assert.assertEquals(1, query2.size());
            Assert.assertEquals("1:Freddie M.:2",query2.get(0));
            //Testing third query
            List<String> query3 = finalStats.get("tiposDeEquipamentoMaisUteis");
            Assert.assertEquals(2, query3.size());
            Assert.assertEquals("0 1", query3.get(0));
            Assert.assertEquals("1 3",query3.get(1));
            //Testing fourth query
            List<String> query4 = finalStats.get("tiposDeZombieESeusEquipamentosDestruidos");
            Assert.assertEquals(1, query4.size());
            Assert.assertEquals("Adulto (Zombie):3:0",query4.get(0));
            //Testing fifth query
            List<String> query5 = finalStats.get("criaturasMaisEquipadas");
            Assert.assertEquals(3, query5.size());
            Assert.assertTrue(query5.contains("6:Paciente Tres:0"));
            Assert.assertTrue(query5.contains("2:Paciente Zero:0"));
            Assert.assertTrue(query5.contains("3:Alice:0"));

        }catch (InvalidTWDInitialFileException | FileNotFoundException e){
            Assert.fail();
        }
    }



}
