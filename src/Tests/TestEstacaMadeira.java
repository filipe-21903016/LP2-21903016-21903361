package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;

import java.io.File;

public class TestEstacaMadeira {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/TestEstacaMadeira.txt");

    @Test
    public void AtacarZombieAdulto(){
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(1, 1,1 , 2));
        Assert.assertTrue(gameManager.move(2, 2, 1, 2));
        int id = gameManager.getElementId(1,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);
    }

    @Test
    public void AtacarZombievampiro(){
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(1, 1,0, 0));
        Assert.assertTrue(gameManager.move(2, 2, 2, 1));
        int id = gameManager.getElementId(2,1);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);
    }

    @Test
    public void DoubleKillVampiroEZombie(){
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(1, 1,1, 2));
        Assert.assertTrue(gameManager.move(2, 2, 1, 2));

        int id = gameManager.getElementId(1,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);

        Assert.assertTrue(gameManager.move(2, 1, 2, 2));
        Assert.assertTrue(gameManager.move(1, 2, 2, 2));

        int id2 = gameManager.getElementId(2,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id2, 1, id2);
    }
}
