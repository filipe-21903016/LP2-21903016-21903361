package pt.ulusofona.lp2.theWalkingDEISIGame;

public class Main {
    public static void main(String[] args) {
        GarrafaDeLixivia garrafa =(GarrafaDeLixivia) EquipmentFactory.makeEquipment(1,7,1,1);
        System.out.println(garrafa.getInfo());
    }
}
