package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.InvalidTWDInitialFileException;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;

import java.io.File;
import java.io.FileNotFoundException;

public class TestCabecaAlho {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/TestCabecaAlho.txt");

    @Test
    public void defendeZombieVampiro()throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(1, 1, 0, 0));
        Assert.assertTrue(gameManager.move(2,2,3,3));
        Assert.assertTrue(gameManager.move(0,0,1,1));
        Assert.assertTrue(gameManager.move(3,3,2,2));
        Assert.assertFalse(gameManager.move(2,1,2,2));
        int id = gameManager.getElementId(2,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);
    }

    @Test
    public void defendeZombieRegular()throws InvalidTWDInitialFileException, FileNotFoundException{
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(1, 1, 2, 2));
        int id = gameManager.getElementId(2,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);
    }

}
