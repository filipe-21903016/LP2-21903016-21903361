package pt.ulusofona.lp2.theWalkingDEISIGame;

public class CreatureFactory {
    public static Creature makeCreature(int idCriatura, String nome, int posX, int posY){
        switch (idCriatura){
            case 0:
                return new CriancaZombie(nome, posX, posY);
            case 1:
                return new AdultoZombie(nome, posX, posY);
            case 2:
                return new MilitarZombie(nome,posX,posY);
            case 3:
                return new IdosoZombie(nome, posX, posY);
            case 4:
                return new VampiroZombie(nome, posX, posY);
            case 5:
                return new CriancaVivo(nome, posX, posY);
            case 6:
                return new AdultoVivo(nome, posX, posY);
            case 7:
                return new MilitarVivo(nome, posX, posY);
            case 8:
                return new IdosoVivo(nome,posX,posY);
            default:
                throw new IllegalArgumentException("Unknown Creature Id: " + idCriatura);
        }
    }
}
