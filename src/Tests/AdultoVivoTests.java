package Tests;
import org.junit.Assert;
import pt.ulusofona.lp2.theWalkingDEISIGame.GameInfo;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;


import org.junit.Test;

import java.io.File;


public class AdultoVivoTests {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("src/Tests/VivoTestData.txt");

    /*
      TRUE:
    * Out of bounds
    * Diagonal
    * Vertical
    * Horizontal
     FALSE:
    * Knight
    * More than 2 spaces
    * */

    @Test
    public void testMove1(){
        //1 Space to right
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,4,3);
        Assert.assertEquals(true,obtained);
    }

    @Test
    public void testMove2() {
        //2 spaces to right
        gameManager.loadGame(fich);
        boolean obtained = gameManager.move(3,3,5,3);
        Assert.assertEquals(true,obtained);
    }
}
