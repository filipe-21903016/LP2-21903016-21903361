package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.Equipamento;
import pt.ulusofona.lp2.theWalkingDEISIGame.InvalidTWDInitialFileException;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;

import java.io.File;
import java.io.FileNotFoundException;

public class TestVeneno {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/TestVeneno.txt");

    private String getEquipmentInfo(int id){
        for(Equipamento e:gameManager.getEquipments()){
            if(e.getId()== id){
                return e.getInfo();
            }
        }
        return "";
    }

    @Test
    public void venenoCheioInfo() throws InvalidTWDInitialFileException, FileNotFoundException  {
        gameManager.startGame(fich);
        Assert.assertEquals("Veneno | 1",getEquipmentInfo(-1));
    }

    @Test
    public void venenoVazio() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        apanhaVenenoSobrevive();
        Assert.assertTrue(gameManager.move(2, 2, 2, 1));
        Assert.assertEquals("Veneno | 0",getEquipmentInfo(-1));

    }

    @Test
    public void apanhaVenenoMorre() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(2, 1, 3, 1));
        Assert.assertTrue(gameManager.move(6, 6, 6, 5));
        Assert.assertTrue(gameManager.move(3, 1, 3, 0));
        Assert.assertTrue(gameManager.move(6, 5, 6, 6));
        Assert.assertTrue(gameManager.move(3, 0, 3, 1));
        Assert.assertTrue(gameManager.move(6, 6, 6, 5));

        int id = gameManager.getElementId(2,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 0, id);
    }

    @Test
    public void apanhaVenenoSobrevive() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(2, 1, 3, 1));

        int id = gameManager.getElementId(2,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);
    }

    @Test
    public void apanhaVenenoDefende() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(2, 1, 2, 2));

        int id = gameManager.getElementId(2,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);
    }

    @Test
    public void apanhaVenenoDefendeEMorre() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(2, 1, 2, 2));
        Assert.assertTrue(gameManager.move(6, 6, 6, 5));
        Assert.assertTrue(gameManager.move(2, 1, 2, 2));


        int id = gameManager.getElementId(2, 2);
        Assert.assertEquals("Id expected to be 3 but was: " + id, 3, id);
    }

    @Test
    public void aombieApanhaVeneno() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        Assert.assertFalse(gameManager.move(2, 1, 2, 2));
    }
}
