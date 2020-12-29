package Tests;
import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.GameInfo;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;

import java.io.File;

public class TestZombieVampiro {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/ZombieVampiroTestData.txt");

    @Test
    public void outOfBounds1() {
        gameManager.startGame(fich);
        if (!gameManager.isDay()){
            boolean obtained = gameManager.move(0,0,-2,0);
            Assert.assertEquals(false,obtained);
        }
    }


    @Test
    public void outOfBounds2() {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(0, 0, 0, -2);
            Assert.assertEquals(false, obtained);
        }
    }

    @Test
    public void outOfBounds3() {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(6, 6, 8, 6);
            Assert.assertEquals(false, obtained);
        }
    }

    @Test
    public void outOfBounds4() {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(6, 6, 8, 6);
            Assert.assertEquals(false, obtained);
        }
    }

    @Test
    public void moveRight(){
        //2 Spaces to right
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 5, 3);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void moveLeft(){
        //2 Spaces to left
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 1, 3);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void moveUp(){
        //2 Space to top
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 3, 1);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void moveDown(){
        //2 Space to bottom
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 3, 5);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void rightUpDiagonal() {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 5, 1);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void leftUpDiagonal() {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 1, 1);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void rightDownDiagonal() {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 5, 5);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void leftDownDiagonal() {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 3, 2);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void validMove1() {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 5, 1);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void validMove2() {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 2, 3);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void validMove3() {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 4, 3);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void validMove4() {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 3, 4);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void validMove5() {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 3, 4, 4);
            Assert.assertEquals(true, obtained);
        }
    }

    @Test
    public void moveByDaylight() {
        gameManager.startGame(fich);
        boolean expected = !gameManager.isDay();
        boolean obtained = gameManager.move(3,3,3,2);
        Assert.assertEquals("Zombie Vampiro não se pode mover durante o dia",expected,obtained);
    }

    @Test
    public void moveRightWithBlockedPath(){
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(2, 3, 4, 3);
            Assert.assertEquals(false, obtained);
        }
    }

    @Test
    public void moveLeftWithBlockedPath() {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(4, 3, 2, 3);
            Assert.assertEquals(false, obtained);
        }
    }

    @Test
    public void moveUpWithBlockedPath() {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 4, 3, 2);
            Assert.assertEquals(false, obtained);
        }
    }

    @Test
    public void moveDownWithBlockedPath() {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(3, 2, 3, 4);
            Assert.assertEquals(false, obtained);
        }
    }

    @Test
    public void moveDiagonalWithBlockedPath() {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(2, 2, 4, 4);
            Assert.assertEquals(false, obtained);
        }
    }

    @Test
    public void moveWithBlockedPathEquipment() {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(2, 4, 2, 6);
            Assert.assertEquals(false, obtained);
        }
    }

    @Test
    public void moveWithSafeHaven() {
        gameManager.startGame(fich);
        if (!gameManager.isDay()) {
            boolean obtained = gameManager.move(2, 0, 2, 2);
            Assert.assertEquals(false, obtained);
        }
    }
}
