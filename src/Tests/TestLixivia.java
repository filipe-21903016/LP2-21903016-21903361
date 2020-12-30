package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.Creature;
import pt.ulusofona.lp2.theWalkingDEISIGame.EscudoMadeira;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;
import java.io.File;

public class TestLixivia {
    TWDGameManager gameManager = new TWDGameManager();
    File fich = new File("test-files/TestLixivia.txt");

    @Test
    public void defende3Vezes() {
        gameManager.startGame(fich);
        Assert.assertTrue(gameManager.move(3,3,2,2));
        Assert.assertTrue(gameManager.move(1,1,2,2)); //defende
        Assert.assertEquals(2,gameManager.getElementId(1,1));
        Assert.assertEquals(1,gameManager.getElementId(2,2));
        Assert.assertFalse("Humano com lixivia nao pode atacar zombie",gameManager.move(2,2,1,1));
        Assert.assertTrue(gameManager.move(2,2,1,2));
        Assert.assertTrue(gameManager.move(2,1,1,2)); //defende
        Assert.assertFalse("Humano com lixivia nao pode atacar zombie",gameManager.move(1,2,1,1));
        Assert.assertTrue(gameManager.move(1,2,0,1));
        Assert.assertTrue(gameManager.move(1,1,0,1)); //defende
        Assert.assertEquals(1,gameManager.getElementId(0,1));
        int id=gameManager.getEquipmentId(1);
        Assert.assertEquals("expected humano equipment id : -1 but was :" + id,-1,id);
    }

    @Test
    public void defende3ETransforma(){
        defende3Vezes();
        Assert.assertTrue(gameManager.move(0,1,1,0));
        Assert.assertTrue(gameManager.move(1,1,1,0));
        for (Creature creature : gameManager.getCreatures()){
            if (creature.getId()==1){
                Assert.assertEquals("1 | Adulto (Zombie) | Os Outros | Mihagi 0 @ (1, 0)",creature.toString());
            }
        }
    }


}
