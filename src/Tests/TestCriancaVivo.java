package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;

import java.io.File;


public class TestCriancaVivo {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/CriancaTestData.txt");

    @Test
    public void outOfBounds1() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(0,0,-1,0);
        Assert.assertFalse(obtained);
    }

    @Test
    public void outOfBounds2() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(0,0,0,-1);
        Assert.assertFalse(obtained);
    }

    @Test
    public void outOfBounds3() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(6,6,7,6);
        Assert.assertFalse(obtained);
    }

    @Test
    public void outOfBounds4() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(6,6,6,7);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneRight(){
        //1 Space to right
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,4,3);
        Assert.assertTrue(obtained);
    }

    @Test
    public void twoRight() {
        //2 spaces to right
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,5,3);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneLeft() {
        //1 space left
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,2,3);
        Assert.assertTrue(obtained);
    }

    @Test
    public void twoLeft() {
        //2 spaces left
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,1,3);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneUp() {
        //one space up
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,3,2);
        Assert.assertTrue(obtained);
    }

    @Test
    public void twoUp() {
        //two spaces up
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,3,1);
        Assert.assertFalse(obtained);
    }
    @Test
    public void oneDown() {
        //one space down
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,3,2);
        Assert.assertTrue(obtained);
    }

    @Test
    public void twoDown() {
        //two spaces down
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,3,5);
        Assert.assertFalse(obtained);
    }

    @Test
    public void illegalDiagonalMove() {
        //two spaces down
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,4,2);
        Assert.assertFalse(obtained);
    }

    @Test
    public void moveRightWithBlockedPath(){
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(2,3,4,3);
        Assert.assertFalse(obtained);
    }

    @Test
    public void moveLeftWithBlockedPath() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(4, 3, 2, 3);
        Assert.assertFalse(obtained);
    }

    @Test
    public void moveUpWithBlockedPath() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3, 4, 3, 2);
        Assert.assertFalse(obtained);
    }

    @Test
    public void moveDownWithBlockedPath() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3, 2, 3, 4);
        Assert.assertFalse(obtained);
    }

    @Test
    public void moveDiagonalWithBlockedPath() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(2, 2, 4, 4);
        Assert.assertFalse(obtained);
    }
}
