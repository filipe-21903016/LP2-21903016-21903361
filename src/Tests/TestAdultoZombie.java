package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.Creature;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;

import java.io.File;

public class TestAdultoZombie {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/ZombieTestData.txt");

    private String getToString(){
        for(Creature c:gameManager.getCreatures()){
            if(c.getId()==1){
                return c.toString();
            }
        }
        return "";
    }

    @Test
    public void adultoZombieToString(){
        gameManager.startGame(fich);
        Assert.assertEquals("1 | Adulto (Zombie) | Os Outros | John Cena 0 @ (3, 3)",getToString());
    }


    @Test
    public void adultoZombieMorreuToString(){
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3,3,4,4));
        Assert.assertTrue(gameManager.move(3,4,3,5));
        Assert.assertTrue(gameManager.move(4,4,3,5));
        Assert.assertEquals("1 | Adulto (Zombie) | Os Outros | John Cena 0 @ RIP",getToString());

    }


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
        Assert.assertTrue(obtained);
    }

    @Test
    public void threeRight() {
        //3 spaces right
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,6,3);
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
        Assert.assertTrue(obtained);
    }

    @Test
    public void threeLeft() {
        //3  spaces left
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,0,3);
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
        Assert.assertTrue(obtained);
    }


    @Test
    public void threeUp() {
        //three spaces up
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,3,0);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneDown() {
        //one space down
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,3,4);
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
    public void threeDown() {
        //three spaces down
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,3,6);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneUpRightDiagonal() {
        //one space in right up diagonal
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,4,2);
        Assert.assertTrue(obtained);
    }

    @Test
    public void twoRightUpDiagonal() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,5,1);
        Assert.assertTrue(obtained);
    }

    @Test
    public void threeRightUpDiagonal() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,6,0);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneLeftUpDiagonal() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,2,2);
        Assert.assertTrue(obtained);
    }

    @Test
    public void twoLeftUpDiagonal() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,1,1);
        Assert.assertTrue(obtained);
    }

    @Test
    public void threeLeftUpDiagonal() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,0,0);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneDownRightDiagonal() {
        //one space in right up diagonal
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,4,4);
        Assert.assertTrue(obtained);
    }

    @Test
    public void twoRightDownDiagonal() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,5,5);
        Assert.assertTrue(obtained);
    }

    @Test
    public void threeRightDownDiagonal() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,6,6);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneLeftDownDiagonal() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,2,4);
        Assert.assertTrue(obtained);
    }

    @Test
    public void twoLeftDownDiagonal() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,5,1);
        Assert.assertTrue(obtained);
    }

    @Test
    public void threeLeftDownDiagonal() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,0,6);
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

    @Test
    public void moveWithBlockedPathEquipment() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(2, 4,2, 6);
        Assert.assertFalse(obtained);
    }

    @Test
    public void moveWithSafeHaven() {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(2, 0, 2, 2);
        Assert.assertFalse(obtained);
    }
}