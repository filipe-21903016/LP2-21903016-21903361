package Tests;
import org.junit.Assert;
import pt.ulusofona.lp2.theWalkingDEISIGame.GameInfo;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;


import org.junit.Test;

import java.io.File;
import java.util.ArrayList;


public class CaoTests {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/CaoTestData.txt");

    @Test
    public void outOfBounds1() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(0,0,-1,-1);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void outOfBounds2() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(6,6,5,7);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void outOfBounds3() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(6,6,7,7);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void outOfBounds4() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(0,0,1,-1);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void oneRight(){
        //1 Space to right
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,4,3);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void oneLeft() {
        //1 space left
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,2,3);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void oneUp() {
        //one space up
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,3,2);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void oneDown() {
        //one space down
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,3,4);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void oneUpRightDiagonal() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,4,2);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void twoRightUpDiagonal() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,5,1);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void threeRightUpDiagonal() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,6,0);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void oneLeftUpDiagonal() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,2,2);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void twoLeftUpDiagonal() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,1,1);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void threeLeftUpDiagonal() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,0,0);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void oneDownRightDiagonal() {
        //one space in right up diagonal
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,4,4);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void twoRightDownDiagonal() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,5,5);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void threeRightDownDiagonal() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,6,6);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void oneLeftDownDiagonal() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,2,4);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void twoLeftDownDiagonal() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,5,1);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void threeLeftDownDiagonal() {
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,0,6);
        Assert.assertEquals(false,obtained);
    }
}
