package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.*;

public class TestCreatureFactory {

    @Test
    public void testCreateBabyZombie(){
        CriancaZombie expected = new CriancaZombie(0,"Zézé",0,0);
        Creature obtained = CreatureFactory.makeCreature(0,0,"Zézé",0,0);
        Assert.assertEquals(expected,obtained);
    }

    @Test
    public void testCreateAdultoZombie(){
        AdultoZombie expected = new AdultoZombie(0,"Sei lá",0,0);
        Creature obtained = CreatureFactory.makeCreature(0,1,"Sei lá",0,0);
        Assert.assertEquals(expected,obtained);
    }

    @Test
    public void testCreateMilitarZombie(){
        MilitarZombie expected = new MilitarZombie(0,"Rambo",0,0);
        Creature obtained = CreatureFactory.makeCreature(0,2,"Rambo",0,0);
        Assert.assertEquals(expected,obtained);
    }

    @Test
    public void testCreateIdosoZombie(){
        IdosoZombie expected = new IdosoZombie(0,"Arnold",0,0);
        Creature obtained = CreatureFactory.makeCreature(0,3,"Arnold",0,0);
        Assert.assertEquals(expected,obtained);
    }

    @Test
    public void testCreateVampiro(){
        VampiroZombie expected = new VampiroZombie(0,"Dracula",0,0);
        Creature obtained = CreatureFactory.makeCreature(0,4,"Dracula",0,0);
        Assert.assertEquals(expected,obtained);
    }

    @Test
    public void testCreateCriancaVivo(){
        CriancaVivo expected = new CriancaVivo(0,"Madalena",0,0);
        Creature obtained = CreatureFactory.makeCreature(0,5,"Madalena",0,0);
        Assert.assertEquals(expected,obtained);
    }

    @Test
    public void testCreateAdultoVivo(){
        AdultoVivo expected = new AdultoVivo(0,"Diogo Alves",0,0);
        Creature obtained = CreatureFactory.makeCreature(0,6,"Diogo Alves",0,0);
        Assert.assertEquals(expected,obtained);
    }

    @Test
    public void testCreateMilitarVivo(){
        MilitarVivo expected = new MilitarVivo(0,"Tenente D.",0,0);
        Creature obtained = CreatureFactory.makeCreature(0,7,"Tenente D.",0,0);
        Assert.assertEquals(expected,obtained);
    }

    @Test
    public void testCreateIdosoVivo(){
        IdosoVivo expected = new IdosoVivo(0,"Pedro Dias",0,0);
        Creature obtained = CreatureFactory.makeCreature(0,8,"Pedro Dias",0,0);
        Assert.assertEquals(expected,obtained);
    }

    @Test
    public void testCreateCao(){
        Cao expected = new Cao(0,"Max",0,0);
        Creature obtained = CreatureFactory.makeCreature(0,9,"Max",0,0);
        Assert.assertEquals(expected,obtained);
    }

    @Test
    public void testCreateOceanMan(){
        ZombieDoFilme expected = new ZombieDoFilme(0,"OceanMan",0,0);
        Creature obtained = CreatureFactory.makeCreature(0,10,"OceanMan",0,0);
        Assert.assertEquals(expected,obtained);
    }

}
