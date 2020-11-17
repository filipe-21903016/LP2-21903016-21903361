package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.Humano;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;

public class TestsHumano {

    @Test
    public void testHumanoToString(){
        Humano humano = new Humano(1,"Freddy M.",3, 3);
        String expected = "1 | Humano | Os Vivos | Freddy M. 0 @ (3, 3)";
        String obtained = humano.toString();
        Assert.assertEquals(expected,obtained);
    }

}
