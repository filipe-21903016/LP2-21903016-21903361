package Tests;
import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.GameInfo;
import pt.ulusofona.lp2.theWalkingDEISIGame.InvalidTWDInitialFileException;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;

import java.io.File;
import java.io.FileNotFoundException;

public class TestZombieVampiro {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/ZombieVampiroTestData.txt");

    @Test
    public void outOfBounds1() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        if (!gameManager.isDay()){
            boolean obtained = gameManager.move(0,0,-2,0);
            Assert.assertEquals(false,obtained);
        }
    }


    @Test
    public void outOfBounds2() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(0, 0, 0, -2);
            Assert.assertEquals(false, obtained);
        }
    }

    @Test
    public void outOfBounds3() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(6, 6, 8, 6);
            Assert.assertEquals(false, obtained);
        }
    }

    @Test
    public void outOfBounds4() throws InvalidTWDInitialFileException, FileNotFoundException{
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(6, 6, 8, 6);
            Assert.assertEquals(false, obtained);
        }
    }

    @Test
    public void moveRight() throws InvalidTWDInitialFileException, FileNotFoundException {
        //2 Spaces to right
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 5, 3);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void moveLeft() throws InvalidTWDInitialFileException, FileNotFoundException {
        //2 Spaces to left
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 1, 3);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void moveUp() throws InvalidTWDInitialFileException, FileNotFoundException {
        //2 Space to top
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 3, 1);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void moveDown() throws InvalidTWDInitialFileException, FileNotFoundException {
        //2 Space to bottom
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 3, 5);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void rightUpDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 5, 1);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void leftUpDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 1, 1);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void rightDownDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 5, 5);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void leftDownDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 3, 2);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void validMove1() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 5, 1);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void validMove2() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 2, 3);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void validMove3() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 4, 3);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void validMove4() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 3, 4);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void validMove5() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 4, 4);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void moveByDaylight() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean expected = !gameManager.isDay();
        boolean obtained = gameManager.move(3,3,3,2);
        Assert.assertEquals("Zombie Vampiro não se pode mover durante o dia",expected,obtained);
    }

    @Test
    public void moveRightWithBlockedPath() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(2, 3, 4, 3);
            Assert.assertEquals(false, obtained);
        }
    }

    @Test
    public void moveLeftWithBlockedPath() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(4, 3, 2, 3);
            Assert.assertEquals(false, obtained);
        }
    }

    @Test
    public void moveUpWithBlockedPath() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 4, 3, 2);
            Assert.assertEquals(false, obtained);
        }
    }

    @Test
    public void moveDownWithBlockedPath() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 2, 3, 4);
            Assert.assertEquals(false, obtained);
        }
    }

    @Test
    public void moveDiagonalWithBlockedPath() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(2, 2, 4, 4);
            Assert.assertEquals(false, obtained);
        }
    }

    @Test
    public void moveWithBlockedPathEquipment() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(2, 4, 2, 6);
            Assert.assertEquals(false, obtained);
        }
    }

    @Test
    public void moveWithSafeHaven() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(2, 0, 2, 2);
            Assert.assertEquals(false, obtained);
        }
    }
}
