package Tests;
import org.junit.Assert;
import pt.ulusofona.lp2.theWalkingDEISIGame.GameInfo;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;


import org.junit.Test;
import java.io.File;
import java.util.ArrayList;

public class TestMilitarVivo {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/MilitarTestData.txt");

    @Test
    public void outOfBounds1() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(0,0,-1,0);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void outOfBounds2() {
        gameManager.startGame(fich);

        boolean obtained = gameManager.move(0,0,0,-1);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void outOfBounds3() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(6,6,7,6);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void outOfBounds4() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(6,6,6,7);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void oneRight(){
        //1 Space to right
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,4,3);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void twoRight() {
        //2 spaces to right
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,5,3);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void threeRight() {
        //3 spaces right
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,6,3);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void fourRight() {
        //4 spaces right
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(0,0,4,0);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void oneLeft() {
        //1 space left
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,2,3);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void twoLeft() {
        //2 spaces left
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,1,3);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void threeLeft() {
        //3  spaces left
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,0,3);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void fourLeft() {
        //4 spaces left
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(6,6,2,6);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void oneUp() {
        //one space up
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,3,2);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void twoUp() {
        //two spaces up
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,3,1);
        Assert.assertEquals(true,obtained);
    }


    @Test
    public void threeUp() {
        //three spaces up
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,3,0);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void fourUp() {
        //four spaces up
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(6,6,6,2);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void oneDown() {
        //one space down
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,3,4);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void twoDown() {
        //two spaces down
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,3,5);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void threeDown() {
        //three spaces down
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,3,6);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void fourDown() {
        //four spaces down
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(0,0,0,4);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void oneUpRightDiagonal() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,4,2);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void twoRightUpDiagonal() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,5,1);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void threeRightUpDiagonal() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,6,0);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void fourRightUpDiagonal() {
        //3 spaces right
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(2,4,6,0);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void oneLeftUpDiagonal() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,2,2);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void twoLeftUpDiagonal() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,1,1);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void threeLeftUpDiagonal() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,0,0);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void fourLeftUpDiagonal() {
        //3 spaces right
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(6,6,2,2);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void oneDownRightDiagonal() {
        //one space in right up diagonal
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,4,4);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void twoRightDownDiagonal() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,5,5);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void threeRightDownDiagonal() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,6,6);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void fourRightDownDiagonal() {
        //3 spaces right
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(0,0,4,4);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void oneLeftDownDiagonal() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,2,4);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void twoLeftDownDiagonal() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,5,1);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void threeLeftDownDiagonal() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,0,6);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void fourLeftDownDiagonal() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(6,0,2,4);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void moveRightWithBlockedPath(){
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(2,3,4,3);
        Assert.assertEquals(false,obtained);
    }

    @Test
    public void moveLeftWithBlockedPath() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(4, 3, 2, 3);
        Assert.assertEquals(false, obtained);
    }

    @Test
    public void moveUpWithBlockedPath() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3, 4, 3, 2);
        Assert.assertEquals(false, obtained);
    }

    @Test
    public void moveDownWithBlockedPath() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3, 2, 3, 4);
        Assert.assertEquals(false, obtained);
    }

    @Test
    public void moveDiagonalWithBlockedPath() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(2, 2, 4, 4);
        Assert.assertEquals(false, obtained);
    }

    @Test
    public void moveWithBlockedPathEquipment() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(2, 4,2, 6);
        Assert.assertEquals(false, obtained);
    }

    @Test
    public void moveWithSafeHaven() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(2, 0, 2, 2);
        Assert.assertEquals(false, obtained);
    }
}



