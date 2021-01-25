package Tests;
import org.junit.Assert;
import pt.ulusofona.lp2.theWalkingDEISIGame.GameInfo;
import pt.ulusofona.lp2.theWalkingDEISIGame.InvalidTWDInitialFileException;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;


import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TestZombieDoFilme {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/ZombieDoFilmeTestData.txt");

    @Test
    public void outOfBounds1() throws InvalidTWDInitialFileException, FileNotFoundException  {
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(0,0,-1,0);
            Assert.assertEquals(false,obtained);
    }

    @Test
    public void outOfBounds2() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(0, 0, 0, -1);
            Assert.assertEquals(false, obtained);
    }

    @Test
    public void outOfBounds3() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(6, 6, 7, 6);
            Assert.assertEquals(false, obtained);
    }

    @Test
    public void outOfBounds4() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(6, 6, 6, 7);
            Assert.assertEquals(false, obtained);
    }

    @Test
    public void oneRight() throws InvalidTWDInitialFileException, FileNotFoundException{
        //1 Space to right
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(3, 3, 4, 3);
            Assert.assertEquals(true, obtained);
    }

    @Test
    public void twoRight() throws InvalidTWDInitialFileException, FileNotFoundException {
        //2 spaces to right
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(3, 3, 5, 3);
            Assert.assertEquals(true, obtained);
    }

    @Test
    public void threeRight() throws InvalidTWDInitialFileException, FileNotFoundException {
        //3 spaces right
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(3, 3, 6, 3);
            Assert.assertEquals(false, obtained);
    }

    @Test
    public void oneLeft() throws InvalidTWDInitialFileException, FileNotFoundException {
        //1 space left
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(3, 3, 2, 3);
            Assert.assertEquals(true, obtained);
    }

    @Test
    public void twoLeft() throws InvalidTWDInitialFileException, FileNotFoundException {
        //2 spaces left
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(3, 3, 1, 3);
            Assert.assertEquals(false, obtained);
    }

    @Test
    public void oneUp() throws InvalidTWDInitialFileException, FileNotFoundException {
        //one space up
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(3, 3, 3, 2);
            Assert.assertEquals(true, obtained);
    }

    @Test
    public void twoUp() throws InvalidTWDInitialFileException, FileNotFoundException {
        //two spaces up
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(3, 3, 3, 1);
            Assert.assertEquals(true, obtained);
    }


    @Test
    public void threeUp() throws InvalidTWDInitialFileException, FileNotFoundException {
        //three spaces up
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(3, 3, 3, 0);
            Assert.assertEquals(true, obtained);
    }

    @Test
    public void fourUp() throws InvalidTWDInitialFileException, FileNotFoundException {
        //four spaces up
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(6, 6, 6, 2);
            Assert.assertEquals(false, obtained);
    }

    @Test
    public void oneDown() throws InvalidTWDInitialFileException, FileNotFoundException {
        //one space down
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(3, 3, 3, 4);
            Assert.assertEquals(true, obtained);
    }

    @Test
    public void twoDown() throws InvalidTWDInitialFileException, FileNotFoundException {
        //two spaces down
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(3, 3, 3, 5);
            Assert.assertEquals(false, obtained);
    }

    @Test
    public void oneUpRightDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        //one space in right up diagonal
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(3, 3, 4, 2);
            Assert.assertEquals(false, obtained);
    }

    @Test
    public void oneLeftUpDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(3, 3, 2, 2);
            Assert.assertEquals(false, obtained);
    }

    @Test
    public void oneDownRightDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        //one space in right up diagonal
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(3, 3, 4, 4);
            Assert.assertEquals(false, obtained);
    }


    @Test
    public void oneLeftDownDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(3, 3, 2, 4);
            Assert.assertEquals(false, obtained);
    }

    @Test
    public void moveRightWithBlockedPath() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(2, 3, 4, 3);
            Assert.assertEquals(false, obtained);
    }

    @Test
    public void moveUpWithBlockedPath() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(3, 4, 3, 2);
            Assert.assertEquals(false, obtained);
    }


    @Test
    public void moveWithBlockedPathEquipment() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(2, 6, 2, 4);
            Assert.assertEquals(false, obtained);
    }

    @Test
    public void moveWithSafeHaven() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
            boolean obtained = gameManager.move(2, 2, 2, 0);
            Assert.assertEquals(false, obtained);
    }
}
