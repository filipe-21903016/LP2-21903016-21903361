package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;

import java.io.File;

public class TestPistolaWaltherPPK {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/TestPistolaPPK.txt");
    File fichHardcore = new File("test-files/TestPistolaHardcore.txt");

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
    public void AtacarZombieVampiro(){
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(1, 1,0 , 0));
        Assert.assertFalse(gameManager.move(2, 2, 2, 1));
        int id = gameManager.getElementId(2,1);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 3, id);
    }

    @Test
    public void DisparaEm3zombies(){
        gameManager.startGame(fichHardcore);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(2, 1, 3, 1));
        Assert.assertTrue(gameManager.move(2, 2, 1, 1));

        int id = gameManager.getElementId(1,1);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);

        Assert.assertTrue(gameManager.move(3, 1, 2, 1));
        Assert.assertTrue(gameManager.move(1, 1, 2, 0));

        int id2 = gameManager.getElementId(2,0);
        Assert.assertEquals("Id expected to be 1 but was: " + id2, 1, id2);

        Assert.assertTrue(gameManager.move(1, 2, 1, 0));
        Assert.assertTrue(gameManager.move(2, 0, 2, 1));

        int id3 = gameManager.getElementId(2,1);
        Assert.assertEquals("Id expected to be 1 but was: " + id3, 1, id3);
    }

    @Test
    public void DisparaEm4zombies(){
        gameManager.startGame(fichHardcore);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(2, 1, 3, 1));
        Assert.assertTrue(gameManager.move(2, 2, 1, 1));

        int id = gameManager.getElementId(1,1);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);

        Assert.assertTrue(gameManager.move(3, 1, 2, 1));
        Assert.assertTrue(gameManager.move(1, 1, 2, 0));

        int id2 = gameManager.getElementId(2,0);
        Assert.assertEquals("Id expected to be 1 but was: " + id2, 1, id2);

        Assert.assertTrue(gameManager.move(1, 2, 1, 0));
        Assert.assertTrue(gameManager.move(2, 0, 2, 1));

        int id3 = gameManager.getElementId(2,1);
        Assert.assertEquals("Id expected to be 1 but was: " + id3, 1, id3);

        Assert.assertTrue(gameManager.move(1, 0, 2, 0));
        Assert.assertFalse(gameManager.move(2, 1, 2, 0));

        int id4 = gameManager.getElementId(2,0);
        Assert.assertEquals("Id expected to be 1 but was: " + id4, 4, id4);
    }


}
