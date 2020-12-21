package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.Vivo;

public class TestsVivo {

    @Test
    public void testHumanoToString(){
        Vivo vivo = new Vivo(1,"Freddy M.",3, 3);
        String expected = "1 | Humano | Os Vivos | Freddy M. 0 @ (3, 3)";
        String obtained = vivo.toString();
        Assert.assertEquals(expected,obtained);
    }

}
