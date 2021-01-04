package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.Equipamento;
import pt.ulusofona.lp2.theWalkingDEISIGame.EscudoMadeira;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;
import java.io.File;

public class TestEscudoMadeira {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/TestEscudoMadeira.txt");

    private String getEquipmentInfo(int id){
        for(Equipamento e:gameManager.getEquipments()){
            if(e.getId()==id){
                return e.getInfo();
            }
        }
        return "";
    }

    @Test
    public void escudoUtilInfo(){
        gameManager.startGame(fich);
        Assert.assertEquals("Escudo de Madeira | 1",getEquipmentInfo(-1));
    }

    @Test
    public void escudoPartidoInfo(){
        gameManager.startGame(fich);
        defender1Ataque();
        Assert.assertTrue(gameManager.move(2,2,3,2));
        Assert.assertEquals("Escudo de Madeira | 0",getEquipmentInfo(-1));
    }

    @Test
    public void defender1Ataque(){
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(1, 1, 2, 2));
        int id = gameManager.getElementId(2,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);
    }

    @Test
    public void defender2Ataques(){
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3, 3, 2, 2));
        Assert.assertTrue(gameManager.move(1, 1, 2, 2));
        Assert.assertTrue(gameManager.move(2, 2, 1, 2));
        Assert.assertTrue(gameManager.move(1, 1, 1, 2));
        int id = gameManager.getElementId(1,2);
        Assert.assertEquals("Id expected to be 1 but was: " + id, 1, id);
        Assert.assertEquals(20,gameManager.gameInfo.getTeamIdByCreatureId(id));
    }


    @Test
    public void usoMilitar(){
        gameManager.startGame(fich);
        gameManager.move(2,1,2,2);
        EscudoMadeira escudoMadeira =(EscudoMadeira) gameManager.gameInfo.getEquipmentById(-1);
        Assert.assertTrue(escudoMadeira.isBuffed());
    }

    @Test
    public void usoNaoMilitar(){
        gameManager.startGame(fich);
        gameManager.move(3,3,2,2);
        EscudoMadeira escudoMadeira =(EscudoMadeira) gameManager.gameInfo.getEquipmentById(-1);
        Assert.assertFalse(escudoMadeira.isBuffed());
    }

}
