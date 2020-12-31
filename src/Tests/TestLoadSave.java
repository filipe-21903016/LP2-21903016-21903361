package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class TestLoadSave {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/TestSaveLoad.txt");

    @Test
    public void saveGame() throws IOException {
        gameManager.startGame(fich);
        File save = new File("test-files/TestNewFile.txt");
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(1, 1, 2, 2));
        Assert.assertTrue(gameManager.move(2, 2,4 , 2));
        gameManager.saveGame(save);
        String expected = "7 7\n" + "20\n" + "2\n" + "1 : 6 : Mihagi : 4 : 2\n" +
                "2 : 1 : Paciente Zero : 1 : 1\n" + "1\n" + "-1 : 8 : 4 : 2\n" + "1\n" + "4 : 4\n" +
                "3\n" + "3 : 3 : 2 : 2\n" + "1 : 1 : 2 : 2\n" + "2 : 2 : 4 : 2\n";
        String data = Files.readString(Path.of("test-files/TestNewFile.txt"));

        Assert.assertEquals(expected, data);

    }
}
