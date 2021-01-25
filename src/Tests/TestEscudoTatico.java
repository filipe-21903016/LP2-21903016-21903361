package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.InvalidTWDInitialFileException;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;

import java.io.File;
import java.io.FileNotFoundException;

public class TestEscudoTatico {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/TestEscudoTatico.txt");

    @Test
    public void defender1Ataque() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(1, 1, 2, 2));
        int id = gameManager.getElementId(2,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);
    }

    @Test
    public void defenderMultiplosAtaques() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(1, 1, 2, 2));
        int id = gameManager.getElementId(2,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);

        Assert.assertTrue(gameManager.move(5, 5, 5, 4));
        Assert.assertTrue(gameManager.move(2, 1, 2, 2));

        int id2 = gameManager.getElementId(2,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id2, 1, id2);

        Assert.assertTrue(gameManager.move(5, 4, 5, 5));
        Assert.assertTrue(gameManager.move(1, 2, 2, 2));

        int id3 = gameManager.getElementId(2,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id3, 1, id3);

        Assert.assertTrue(gameManager.move(5, 5, 5, 4));
        Assert.assertTrue(gameManager.move(2, 1, 2, 2));

        int id4 = gameManager.getElementId(2,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id4, 1, id4);
    }



}
