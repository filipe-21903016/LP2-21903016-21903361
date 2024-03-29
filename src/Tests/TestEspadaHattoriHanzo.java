package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.EscudoMadeira;
import pt.ulusofona.lp2.theWalkingDEISIGame.InvalidTWDInitialFileException;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;
import java.io.File;
import java.io.FileNotFoundException;

public class TestEspadaHattoriHanzo {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/TestEspadaHattoriHanzo.txt");

    @Test
    public void atacarZombieAdulto() throws InvalidTWDInitialFileException,FileNotFoundException{
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(1, 1,1 , 2));
        Assert.assertTrue(gameManager.move(2, 2, 1, 2));
        int id = gameManager.getElementId(1,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);
    }

    @Test
    public void criancaAtacaZombieAdultoComEspada() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(2, 1, 2, 2));
        Assert.assertTrue(gameManager.move(1, 1, 1, 2));
        Assert.assertFalse(gameManager.move(2, 2, 1, 2));
        int id = gameManager.getElementId(1,2);
        Assert.assertEquals("Id expected to be 2 but was: " + id, 2, id);
        id= gameManager.getElementId(2,2);
        Assert.assertEquals("Id expected to be 3 but was: " + id,3,id);
    }

    @Test
    public void criancaAtacaZombieCrianca()throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(2, 1, 2, 2));
        Assert.assertTrue(gameManager.move(2, 0, 2, 1));
        Assert.assertTrue(gameManager.move(2, 2, 2, 1));
        Assert.assertTrue(gameManager.move(1, 1, 2, 1));
        int id = gameManager.getElementId(2,1);
        Assert.assertEquals("Id expected to be 3 but was: " + id, 3, id);
        id = gameManager.getElementId(1,1);
        Assert.assertEquals(2,id);
    }

}
