package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.Humano;
import pt.ulusofona.lp2.theWalkingDEISIGame.Zombie;

public class TestsZombie {
    @Test
    public void testZombieToString(){
        Zombie zombie = new Zombie(3,"Paciente Zero",4, 4);
        String expected = "3 | Zombie | Os Outros | Paciente Zero 0 @ (4, 4)";
        String obtained = zombie.toString();
        Assert.assertEquals(expected,obtained);
    }
}