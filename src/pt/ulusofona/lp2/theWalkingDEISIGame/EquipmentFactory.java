package pt.ulusofona.lp2.theWalkingDEISIGame;

public class EquipmentFactory {
    public static Equipamento makeEquipment(int id, int posX, int posY){
        switch (id){
            case 0: return new EscudoMadeira(id,posX,posY);
            case -1: return new EspadaHattoriHanzo(id,posX,posY);
            case -2: return new PistolaWaltherPPK(id,posX,posY);
            case -3: return new EscudoTatico(id,posX,posY);
            case -4: return new RevistaMaria(id,posX,posY);
            case -5: return new CabecaDeAlho(id,posX,posY);
            case -6: return new EstacaDeMadeira(id, posX, posY);
            case -7: return new GarrafaDeLixivia(id, posX, posY);
            case -8: return new Veneno(id, posX, posY);
            case -9: return new Antidoto(id, posX, posY);
            case -10: return new BeskarHelmet(id, posX, posY);
            default: throw new IllegalArgumentException("Unknown Equipment Id: " + id);
        }
    }
}
