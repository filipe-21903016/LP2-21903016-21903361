package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.TWDGameManager;

public class TestsMove {


    //Testing Zombies---------------

    @Test
    public void testMoveZombieDiagonal() {
        TWDGameManager manager = new TWDGameManager();
        manager.gameInfo.setNrColumns(5);
        manager.gameInfo.setNrLines(5);
        manager.gameInfo.setCurrentTeamID(1);
        manager.gameInfo.addCreature(3, 0, "Paciente Zero", 4, 4);
        boolean obtained = manager.move(4, 4, 3, 3);
        Assert.assertEquals(false, obtained);
    }

    @Test
    public void testMoveZombieOutOfBoundsX() {
        TWDGameManager manager = new TWDGameManager();
        manager.gameInfo.setNrColumns(5);
        manager.gameInfo.setNrLines(5);
        manager.gameInfo.setCurrentTeamID(1);
        manager.gameInfo.addCreature(3, 0, "Paciente Zero", 0, 0);
        boolean obtained = manager.move(0, 0, -1, 0);
        Assert.assertEquals(false, obtained);
    }

    @Test
    public void testMoveZombieOutOfBoundsY() {
        TWDGameManager manager = new TWDGameManager();
        manager.gameInfo.setNrColumns(5);
        manager.gameInfo.setNrLines(5);
        manager.gameInfo.setCurrentTeamID(1);
        manager.gameInfo.addCreature(3, 0, "Paciente Zero", 0, 0);
        boolean obtained = manager.move(0, 0, 0, -1);
        Assert.assertEquals(false, obtained);
    }

    @Test
    public void testMoveZombieToOcupiedSpot() {
        TWDGameManager manager = new TWDGameManager();
        manager.gameInfo.setNrColumns(5);
        manager.gameInfo.setNrLines(5);
        manager.gameInfo.setCurrentTeamID(1);
        manager.gameInfo.addCreature(1, 0, "Freddy M.", 3, 3);
        manager.gameInfo.addCreature(3, 0, "Paciente Zero", 2, 3);
        boolean obtained = manager.move(2, 3, 3, 3);
        Assert.assertEquals(false, obtained);
    }

    @Test
    public void testTopBoundriesZombie() {
        TWDGameManager manager = new TWDGameManager();
        manager.gameInfo.setNrColumns(5);
        manager.gameInfo.setNrLines(5);
        manager.gameInfo.setCurrentTeamID(1);
        manager.gameInfo.addCreature(3, 0, "Paciente Zero", 4, 4);
        boolean obtained = manager.move(4, 4, 5, 4);
        Assert.assertEquals(false, obtained);
    }

    @Test
    public void testValidMoveZombie() {
        TWDGameManager manager = new TWDGameManager();
        manager.gameInfo.setNrColumns(5);
        manager.gameInfo.setNrLines(5);
        manager.gameInfo.setCurrentTeamID(1);
        manager.gameInfo.addCreature(3, 0, "Paciente Zero", 0, 1);
        boolean obtained = manager.move(0, 1, 0, 2);
        Assert.assertEquals(true, obtained);
    }

    @Test
    public void testInvalidMoveZombieOutOfTurn() {
        TWDGameManager manager = new TWDGameManager();
        manager.gameInfo.setNrColumns(5);
        manager.gameInfo.setNrLines(5);
        manager.gameInfo.setCurrentTeamID(0);
        manager.gameInfo.addCreature(3, 0, "Paciente Zero", 0, 1);
        boolean obtained = manager.move(0, 1, 0, 2);
        Assert.assertEquals(false, obtained);
    }


    //Testing Human -----------
    @Test
    public void testMoveHumanDiagonal() {
        TWDGameManager manager = new TWDGameManager();
        manager.gameInfo.setNrColumns(5);
        manager.gameInfo.setNrLines(5);
        manager.gameInfo.setCurrentTeamID(0);
        manager.gameInfo.addCreature(1, 0, "Freddy M.", 3, 3);
        boolean obtained = manager.move(3, 3, 4, 4);
        Assert.assertEquals(false, obtained);
    }

    @Test
    public void testMoveHumanOutOfBoundsX() {
        TWDGameManager manager = new TWDGameManager();
        manager.gameInfo.setNrColumns(5);
        manager.gameInfo.setNrLines(5);
        manager.gameInfo.setCurrentTeamID(0);
        manager.gameInfo.addCreature(1, 0, "Freddy M.", 0, 0);
        boolean obtained = manager.move(0, 0, -1, 0);
        Assert.assertEquals(false, obtained);
    }

    @Test
    public void testMoveHumanOutOfBoundsY() {
        TWDGameManager manager = new TWDGameManager();
        manager.gameInfo.setNrColumns(5);
        manager.gameInfo.setNrLines(5);
        manager.gameInfo.setCurrentTeamID(0);
        manager.gameInfo.addCreature(1, 0, "Freddy M.", 0, 0);
        boolean obtained = manager.move(0, 0, 0, -1);
        Assert.assertEquals(false, obtained);
    }

    @Test
    public void testMoveHumanToOcupiedSpot() {
        TWDGameManager manager = new TWDGameManager();
        manager.gameInfo.setNrColumns(5);
        manager.gameInfo.setNrLines(5);
        manager.gameInfo.setCurrentTeamID(0);
        manager.gameInfo.addCreature(1, 0, "Freddy M.", 3, 3);
        manager.gameInfo.addCreature(3, 0, "Paciente Zero", 3, 3);
        boolean obtained = manager.move(3, 3, 2, 3);
        Assert.assertEquals(false, obtained);
    }


    @Test
    public void testTopBoundriesHuman() {
        TWDGameManager manager = new TWDGameManager();
        manager.gameInfo.setNrColumns(5);
        manager.gameInfo.setNrLines(5);
        manager.gameInfo.setCurrentTeamID(0);
        manager.gameInfo.addCreature(1, 0, "Freddy M.", 4, 4);
        boolean obtained = manager.move(4, 4, 4, 5);
        Assert.assertEquals(false, obtained);
    }


    @Test
    public void testValidMoveHuman() {
        TWDGameManager manager = new TWDGameManager();
        manager.gameInfo.setNrColumns(5);
        manager.gameInfo.setNrLines(5);
        manager.gameInfo.setCurrentTeamID(0);
        manager.gameInfo.addCreature(1, 1, "Freddy M.", 0, 0);
        boolean obtained = manager.move(0, 0, 0, 1);
        Assert.assertEquals(true, obtained);
    }


    @Test
    public void testInvalidMoveHumanOutOfTurn() {
        TWDGameManager manager = new TWDGameManager();
        manager.gameInfo.setNrColumns(5);
        manager.gameInfo.setNrLines(5);
        manager.gameInfo.setCurrentTeamID(1);
        manager.gameInfo.addCreature(1, 1, "Freddy M.", 4, 4);
        boolean obtained = manager.move(4, 4, 4, 3);
        Assert.assertEquals(false, obtained);
    }
}
