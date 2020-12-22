package pt.ulusofona.lp2.theWalkingDEISIGame;

public class CreatureFactory {
    public static Creature makeCreature(int idCriatura,int idType, String nome, int posX, int posY) {
        switch (idType) {
            case 0:
                return new CriancaZombie(idCriatura, nome, posX, posY);
            case 1:
                return new AdultoZombie(idCriatura, nome, posX, posY);
            case 2:
                return new MilitarZombie(idCriatura, nome, posX, posY);
            case 3:
                return new IdosoZombie(idCriatura, nome, posX, posY);
            case 4:
                return new VampiroZombie(idCriatura, nome, posX, posY);
            case 5:
                return new CriancaVivo(idCriatura, nome, posX, posY);
            case 6:
                return new AdultoVivo(idCriatura, nome, posX, posY);
            case 7:
                return new MilitarVivo(idCriatura, nome, posX, posY);
            case 8:
                return new IdosoVivo(idCriatura, nome, posX, posY);
            case 9:
                return new Cao(idCriatura, nome, posX, posY);
            default:
                throw new IllegalArgumentException("Unknown Creature Id: " + idType);
        }
    }
}
