package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.InvalidTWDInitialFileException;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;

import java.io.File;
import java.io.FileNotFoundException;

public class TestBeskarHelmet {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/TestBeskarHelmet.txt");

    @Test
    public void apanhaZombie()throws InvalidTWDInitialFileException, FileNotFoundException{
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 3, 4));
        Assert.assertTrue(gameManager.move(2,1,2,2));

        int id = gameManager.getElementId(2,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 3, id);
    }

    @Test
    public void apanhaZombieEFoge()throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 3, 4));
        Assert.assertTrue(gameManager.move(2,1,2,2));
        Assert.assertTrue(gameManager.move(3, 4, 3, 3));
        Assert.assertTrue(gameManager.move(2,2,4,2));

        int id = gameManager.getElementId(2,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 0, id);
    }

    @Test
    public void defendeUmAtaqueZombie()throws InvalidTWDInitialFileException, FileNotFoundException{
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(2,1,2,2));

        int id = gameManager.getElementId(2,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);
    }

    @Test
    public void atacaZombieUmaVez()throws InvalidTWDInitialFileException, FileNotFoundException{
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(2,1,3,1));
        Assert.assertTrue(gameManager.move(2,2,3,1));

        int id = gameManager.getElementId(3,1);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);
    }

    @Test
    public void defendeMultiplosAtaques()throws InvalidTWDInitialFileException, FileNotFoundException{
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(2,1,2,2));
        Assert.assertTrue(gameManager.move(6, 6, 6, 5));
        Assert.assertTrue(gameManager.move(1,1,2,2));

        int id = gameManager.getElementId(2,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);
    }

    @Test
    public void atacaZombieMultiplasVezes()throws InvalidTWDInitialFileException, FileNotFoundException{
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(2,1,3,1));
        Assert.assertTrue(gameManager.move(2,2,3,1));
        Assert.assertTrue(gameManager.move(1, 1, 2, 1));
        Assert.assertTrue(gameManager.move(3, 1, 2, 1));


        int id = gameManager.getElementId(2,1);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);
    }

    @Test
    public void atacaEDefende()throws InvalidTWDInitialFileException, FileNotFoundException{
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(2,1,2,2));
        Assert.assertTrue(gameManager.move(2,2,2,1));

        int id = gameManager.getElementId(2,1);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);
    }
}
