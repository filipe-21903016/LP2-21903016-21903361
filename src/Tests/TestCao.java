package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.InvalidTWDInitialFileException;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;

import java.io.File;
import java.io.FileNotFoundException;


public class TestCao {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/CaoTestData.txt");

    @Test
    public void outOfBounds1() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(0, 0, -1, -1);
        Assert.assertFalse(obtained);
    }

    @Test
    public void outOfBounds2() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(6, 6, 5, 7);
        Assert.assertFalse(obtained);
    }

    @Test
    public void outOfBounds3() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(6, 6, 7, 7);
        Assert.assertFalse(obtained);
    }

    @Test
    public void outOfBounds4() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(0, 0, 1, -1);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneRight() throws InvalidTWDInitialFileException, FileNotFoundException {
        //1 Space to right
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3, 3, 4, 3);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneLeft() throws InvalidTWDInitialFileException, FileNotFoundException {
        //1 space left
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3, 3, 2, 3);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneUp() throws InvalidTWDInitialFileException, FileNotFoundException {
        //one space up
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3, 3, 3, 2);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneDown() throws InvalidTWDInitialFileException, FileNotFoundException {
        //one space down
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3, 3, 3, 4);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneUpRightDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3, 3, 4, 2);
        Assert.assertTrue(obtained);
    }

    @Test
    public void twoRightUpDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3, 3, 5, 1);
        Assert.assertTrue(obtained);
    }

    @Test
    public void threeRightUpDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3, 3, 6, 0);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneLeftUpDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3, 3, 2, 2);
        Assert.assertTrue(obtained);
    }

    @Test
    public void twoLeftUpDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3, 3, 1, 1);
        Assert.assertTrue(obtained);
    }

    @Test
    public void threeLeftUpDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3, 3, 0, 0);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneDownRightDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        //one space in right up diagonal
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3, 3, 4, 4);
        Assert.assertTrue(obtained);
    }

    @Test
    public void twoRightDownDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3, 3, 5, 5);
        Assert.assertTrue(obtained);
    }

    @Test
    public void threeRightDownDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3, 3, 6, 6);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneLeftDownDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3, 3, 2, 4);
        Assert.assertTrue(obtained);
    }

    @Test
    public void twoLeftDownDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3, 3, 5, 1);
        Assert.assertTrue(obtained);
    }

    @Test
    public void threeLeftDownDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3, 3, 0, 6);
        Assert.assertFalse(obtained);
    }

    @Test
    public void moveDiagonalWithBlockedPath() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(2, 2, 4, 4);
        Assert.assertFalse(obtained);
    }

    @Test
    public void moveDiagonalWithBlockedPath2() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(4, 4, 2, 2);
        Assert.assertFalse(obtained);
    }

    @Test
    public void moveDiagonalWithBlockedPath3() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(4, 2, 2, 4);
        Assert.assertFalse(obtained);
    }

    @Test
    public void moveDiagonalWithBlockedPath4() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(2, 4, 4, 2);
        Assert.assertFalse(obtained);
    }

    @Test
    public void moveWithBlockedPathEquipment() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(4, 1, 6, 3);
        Assert.assertFalse(obtained);
    }

    @Test
    public void moveWithSafeHaven() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(1, 2, 3, 0);
        Assert.assertFalse(obtained);
    }
}

