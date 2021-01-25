package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.InvalidTWDInitialFileException;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;

import java.io.File;
import java.io.FileNotFoundException;

public class TesteRevistaMaria {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/TestRevistaMaria.txt");

    @Test
    public void protegeContraIdosoZombie() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(2, 1, 2, 2));
        int id = gameManager.getElementId(2, 2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);
    }

    @Test
    public void protegeContraAdultoZombie() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(2, 1, 2, 2));
        int id = gameManager.getElementId(2, 2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);

    }

    @Test
    public void protegeContraIdosoMasNaoAdulto() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(2, 1, 2, 2));
        int id = gameManager.getElementId(2, 2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);

        Assert.assertTrue(gameManager.move(6, 6, 6, 5));
        Assert.assertTrue(gameManager.move(2, 1, 2, 2));
        int id2 = gameManager.getElementId(2, 2);
        Assert.assertEquals("Id expected to be 1 but was: " + id2, 1, id2);
    }
}
