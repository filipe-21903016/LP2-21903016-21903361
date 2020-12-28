package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;

import java.io.File;

public class TestIdosoZombie {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/IdosoZombieTestData.txt");

    @Test
    public void outOfBounds1() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(0,0,-1,0);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void outOfBounds2() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(0,0,0,-1);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void outOfBounds3() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(6,6,7,6);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void outOfBounds4() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(6,6,6,7);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void oneRight(){
        //1 Space to right
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,4,3);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void twoRight() {
        //2 spaces to right
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,5,3);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void oneLeft() {
        //1 space left
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,2,3);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void twoLeft() {
        //2 spaces left
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,1,3);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void oneUp() {
        //one space up
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,3,2);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void twoUp() {
        //two spaces up
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,3,1);
        Assert.assertEquals(false,obtained);
    }
    @Test
    public void oneDown() {
        //one space down
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,3,2);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void twoDown() {
        //two spaces down
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,3,5);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void illegalDiagonalMove() {
        //two spaces down
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,4,2);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void moveRightWithBlockedPath(){
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(2,3,4,3);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void moveLeftWithBlockedPath() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(4, 3, 2, 3);
        Assert.assertEquals(false, obtained);
    }

    @Test
    public void moveUpWithBlockedPath() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3, 4, 3, 2);
        Assert.assertEquals(false, obtained);
    }

    @Test
    public void moveDownWithBlockedPath() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3, 2, 3, 4);
        Assert.assertEquals(false, obtained);
    }

    @Test
    public void moveDiagonalWithBlockedPath() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(2, 2, 4, 4);
        Assert.assertEquals(false, obtained);
    }
}
