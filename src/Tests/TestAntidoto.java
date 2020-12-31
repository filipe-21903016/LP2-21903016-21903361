package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;

import java.io.File;

import java.io.File;

public class TestAntidoto {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/TestAntidoto.txt");

    @Test
    public void curaEnvenenado(){
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 3, 2));
        Assert.assertTrue(gameManager.move(1, 1,3 , 1));
        Assert.assertTrue(gameManager.move(3, 2, 2, 2));
        int id = gameManager.getElementId(2,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);
    }

    @Test
    public void curaEnvenenadoEsperaTresTurnos(){
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 3, 2));
        Assert.assertTrue(gameManager.move(1, 1,3 , 1));
        Assert.assertTrue(gameManager.move(3, 2, 2, 2));
        Assert.assertTrue(gameManager.move(1, 2, 1, 1));
        Assert.assertTrue(gameManager.move(2, 2, 2, 4));
        Assert.assertFalse(gameManager.move(3, 1, 3, 2));
        Assert.assertTrue(gameManager.move(3, 1, 2, 1));
        Assert.assertTrue(gameManager.move(2, 4, 0, 4));

        int id = gameManager.getElementId(0,4);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);
    }

    @Test
    public void EnvenenadoDefendeCura(){
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(6, 6, 6, 5));
        Assert.assertTrue(gameManager.move(1, 1,3 , 1));
        Assert.assertTrue(gameManager.move(3, 3, 3, 2));
        Assert.assertTrue(gameManager.move(3, 1, 3, 2));

        int id = gameManager.getElementId(3,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);
    }

    @Test
    public void EnvenenadoDefendeCuraEMorre(){
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(6, 6, 6, 5));
        Assert.assertTrue(gameManager.move(1, 1,3 , 1));
        Assert.assertTrue(gameManager.move(3, 3, 3, 2));
        Assert.assertTrue(gameManager.move(3, 1, 3, 2));

        int id = gameManager.getElementId(3,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);

        Assert.assertTrue(gameManager.move(3, 2, 3, 4));
        Assert.assertTrue(gameManager.move(3, 1, 4, 1));

        int id2 = gameManager.getElementId(3,4);
        Assert.assertEquals("Id expected to be 1 but was: " + id2, 0, id2);
    }

    @Test
    public void apanhaAntidotoPrimeiro(){
        gameManager.startGame(fich);
        Assert.assertFalse(gameManager.move(3, 3, 2, 2));
    }
}