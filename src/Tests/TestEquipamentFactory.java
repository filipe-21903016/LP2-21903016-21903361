package Tests;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.theWalkingDEISIGame.*;

public class TestEquipamentFactory {
    @Test
    public void testCreateEscudoMadeira(){
        EscudoMadeira expected = new EscudoMadeira(0,0,0);
        Equipamento obtained = EquipmentFactory.makeEquipment(0,0,0,0);
        Assert.assertEquals(expected,obtained);
    }
    @Test
    public void testCreateEspada(){
        EspadaHattoriHanzo expected = new EspadaHattoriHanzo(0,0,0);
        Equipamento obtained = EquipmentFactory.makeEquipment(0,1,0,0);
        Assert.assertEquals(expected,obtained);
    }

    @Test
    public void testCreatePistola(){
        PistolaWaltherPPK expected = new PistolaWaltherPPK(0,0,0);
        Equipamento obtained = EquipmentFactory.makeEquipment(0,2,0,0);
        Assert.assertEquals(expected,obtained);
    }

    @Test
    public void testCreateEscudoTatico(){
        EscudoTatico expected = new EscudoTatico(0,0,0);
        Equipamento obtained = EquipmentFactory.makeEquipment(0,3,0,0);
        Assert.assertEquals(expected,obtained);
    }

    @Test
    public void testCreateRevista(){
        RevistaMaria expected = new RevistaMaria(0,0,0);
        Equipamento obtained = EquipmentFactory.makeEquipment(0,4,0,0);
        Assert.assertEquals(expected,obtained);
    }

    @Test
    public void testCreateAlho(){
        CabecaDeAlho expected = new CabecaDeAlho(0,0,0);
        Equipamento obtained = EquipmentFactory.makeEquipment(0,5,0,0);
        Assert.assertEquals(expected,obtained);
    }

    @Test
    public void testCreateEstaca(){
        EstacaDeMadeira expected = new EstacaDeMadeira(0,0,0);
        Equipamento obtained = EquipmentFactory.makeEquipment(0,6,0,0);
        Assert.assertEquals(expected,obtained);
    }

    @Test
    public void testCreateLixivia(){
        GarrafaDeLixivia expected = new GarrafaDeLixivia(0,0,0);
        Equipamento obtained = EquipmentFactory.makeEquipment(0,7,0,0);
        Assert.assertEquals(expected,obtained);
    }

    @Test
    public void testCreateVeneno(){
        Veneno expected = new Veneno(0,0,0);
        Equipamento obtained = EquipmentFactory.makeEquipment(0,8,0,0);
        Assert.assertEquals(expected,obtained);
    }

    @Test
    public void testCreateAntidoto(){
        Antidoto expected = new Antidoto(0,0,0);
        Equipamento obtained = EquipmentFactory.makeEquipment(0,9,0,0);
        Assert.assertEquals(expected,obtained);
    }

    @Test
    public void testCreateBeskarHelmet(){
        BeskarHelmet expected = new BeskarHelmet(0,0,0);
        Equipamento obtained = EquipmentFactory.makeEquipment(0,10,0,0);
        Assert.assertEquals(expected,obtained);
    }

}
