package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;

import java.io.File;

public class TestVeneno {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/TestVeneno.txt");

    @Test
    public void ApanhaVenenoMorre(){
        gameManager.startGame(fich);
        Assert.assertFalse(gameManager.move(3, 3, 2, 2));
        Assert.assertFalse(gameManager.move(2, 1, 3, 1));
        Assert.assertFalse(gameManager.move(6, 6, 6, 5));
        Assert.assertFalse(gameManager.move(3, 1, 3, 0));
        Assert.assertFalse(gameManager.move(6, 5, 6, 6));
        Assert.assertFalse(gameManager.move(3, 0, 3, 1));
        Assert.assertFalse(gameManager.move(6, 6, 6, 5));

        int id = gameManager.getElementId(2,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 0, id);
    }

    @Test
    public void ApanhaVenenoSobrevive(){
        gameManager.startGame(fich);
        Assert.assertFalse(gameManager.move(3, 3, 2, 2));
        Assert.assertFalse(gameManager.move(2, 1, 3, 1));

        int id = gameManager.getElementId(2,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);
    }

    @Test
    public void ApanhaVenenoDefende(){
        gameManager.startGame(fich);
        Assert.assertFalse(gameManager.move(3, 3, 2, 2));
        Assert.assertFalse(gameManager.move(2, 1, 2, 2));

        int id = gameManager.getElementId(2,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);
    }
}
