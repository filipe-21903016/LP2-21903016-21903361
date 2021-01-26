package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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



}
