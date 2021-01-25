package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.InvalidTWDInitialFileException;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;

import java.io.File;
import java.io.FileNotFoundException;

public class TestLoadSave {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/TestSaveLoad.txt");


    @Test
    public void saveGame() throws InvalidTWDInitialFileException, FileNotFoundException  {
        gameManager.startGame(fich);
        File save = new File("test-files/TestNewFile.txt");
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(1, 1, 2, 1));
        Assert.assertTrue(gameManager.move(2, 2,4 , 2));
        gameManager.saveGame(save);
        Assert.assertTrue(gameManager.move(2, 1,2 , 3));
        gameManager.loadGame(save);
        Assert.assertEquals(0,gameManager.getElementId(2,3));
        Assert.assertEquals(2,gameManager.getElementId(2,1));
        Assert.assertEquals(1,gameManager.getElementId(4,2));
    }
}
