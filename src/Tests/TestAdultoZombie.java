package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.Creature;
import pt.ulusofona.lp2.theWalkingDEISIGame.InvalidTWDInitialFileException;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;

import java.io.File;
import java.io.FileNotFoundException;

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
    public void adultoZombieToString() throws InvalidTWDInitialFileException, FileNotFoundException{
        gameManager.startGame(fich);
        Assert.assertEquals("1 | Adulto (Zombie) | Os Outros | John Cena 0 @ (3, 3)",getToString());
    }


    @Test
    public void adultoZombieMorreuToString() throws InvalidTWDInitialFileException, FileNotFoundException{
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3,3,4,4));
        Assert.assertTrue(gameManager.move(3,4,3,5));
        Assert.assertTrue(gameManager.move(4,4,3,5));
        Assert.assertEquals("1 | Adulto (Zombie) | Os Outros | John Cena 0 @ RIP",getToString());

    }


    @Test
    public void outOfBounds1() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(0,0,-1,0);
        Assert.assertFalse(obtained);
    }

    @Test
    public void outOfBounds2() throws InvalidTWDInitialFileException, FileNotFoundException{
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(0,0,0,-1);
        Assert.assertFalse(obtained);
    }

    @Test
    public void outOfBounds3() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(6,6,7,6);
        Assert.assertFalse(obtained);
    }

    @Test
    public void outOfBounds4() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(6,6,6,7);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneRight() throws InvalidTWDInitialFileException, FileNotFoundException{
        //1 Space to right
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,4,3);
        Assert.assertTrue(obtained);
    }

    @Test
    public void twoRight() throws InvalidTWDInitialFileException, FileNotFoundException {
        //2 spaces to right
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,5,3);
        Assert.assertTrue(obtained);
    }

    @Test
    public void threeRight() throws InvalidTWDInitialFileException, FileNotFoundException {
        //3 spaces right
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,6,3);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneLeft() throws InvalidTWDInitialFileException, FileNotFoundException {
        //1 space left
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,2,3);
        Assert.assertTrue(obtained);
    }

    @Test
    public void twoLeft() throws InvalidTWDInitialFileException, FileNotFoundException {
        //2 spaces left
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,1,3);
        Assert.assertTrue(obtained);
    }

    @Test
    public void threeLeft() throws InvalidTWDInitialFileException, FileNotFoundException {
        //3  spaces left
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,0,3);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneUp() throws InvalidTWDInitialFileException, FileNotFoundException {
        //one space up
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,3,2);
        Assert.assertTrue(obtained);
    }

    @Test
    public void twoUp() throws InvalidTWDInitialFileException, FileNotFoundException {
        //two spaces up
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,3,1);
        Assert.assertTrue(obtained);
    }


    @Test
    public void threeUp() throws InvalidTWDInitialFileException, FileNotFoundException {
        //three spaces up
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,3,0);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneDown() throws InvalidTWDInitialFileException, FileNotFoundException {
        //one space down
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,3,4);
        Assert.assertTrue(obtained);
    }

    @Test
    public void twoDown() throws InvalidTWDInitialFileException, FileNotFoundException {
        //two spaces down
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,3,5);
        Assert.assertFalse(obtained);
    }

    @Test
    public void threeDown()  throws InvalidTWDInitialFileException, FileNotFoundException{
        //three spaces down
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,3,6);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneUpRightDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        //one space in right up diagonal
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,4,2);
        Assert.assertTrue(obtained);
    }

    @Test
    public void twoRightUpDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,5,1);
        Assert.assertTrue(obtained);
    }

    @Test
    public void threeRightUpDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,6,0);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneLeftUpDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,2,2);
        Assert.assertTrue(obtained);
    }

    @Test
    public void twoLeftUpDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,1,1);
        Assert.assertTrue(obtained);
    }

    @Test
    public void threeLeftUpDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,0,0);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneDownRightDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        //one space in right up diagonal
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,4,4);
        Assert.assertTrue(obtained);
    }

    @Test
    public void twoRightDownDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,5,5);
        Assert.assertTrue(obtained);
    }

    @Test
    public void threeRightDownDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,6,6);
        Assert.assertFalse(obtained);
    }

    @Test
    public void oneLeftDownDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,2,4);
        Assert.assertTrue(obtained);
    }

    @Test
    public void twoLeftDownDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,5,1);
        Assert.assertTrue(obtained);
    }

    @Test
    public void threeLeftDownDiagonal() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3,3,0,6);
        Assert.assertFalse(obtained);
    }

    @Test
    public void moveRightWithBlockedPath() throws InvalidTWDInitialFileException, FileNotFoundException  {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(2,3,4,3);
        Assert.assertFalse(obtained);
    }

    @Test
    public void moveLeftWithBlockedPath() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(4, 3, 2, 3);
        Assert.assertFalse(obtained);
    }

    @Test
    public void moveUpWithBlockedPath() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3, 4, 3, 2);
        Assert.assertFalse(obtained);
    }

    @Test
    public void moveDownWithBlockedPath() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(3, 2, 3, 4);
        Assert.assertFalse(obtained);
    }

    @Test
    public void moveDiagonalWithBlockedPath() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(2, 2, 4, 4);
        Assert.assertFalse(obtained);
    }

    @Test
    public void moveWithBlockedPathEquipment() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(2, 4,2, 6);
        Assert.assertFalse(obtained);
    }

    @Test
    public void moveWithSafeHaven() throws InvalidTWDInitialFileException, FileNotFoundException {
        gameManager.startGame(fich);
        boolean obtained = gameManager.move(2, 0, 2, 2);
        Assert.assertFalse(obtained);
    }
}