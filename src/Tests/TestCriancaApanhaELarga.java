package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.InvalidTWDInitialFileException;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class TestCriancaApanhaELarga {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/Test-DP.txt");

    @Test
    public void test(){
        try{
            gameManager.startGame(fich);
        }catch(InvalidTWDInitialFileException | FileNotFoundException e){
            e.getLocalizedMessage();
        }

        Map<String, List<String>> startStats = gameManager.getGameStatistics();

        List<String> criancasMaisEquipadas = startStats.get("criaturasMaisEquipadas");
        Assert.assertEquals(2,criancasMaisEquipadas.size());
    }
}
