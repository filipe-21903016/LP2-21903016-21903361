package pt.ulusofona.lp2.theWalkingDEISIGame;

public class CriancaZombie extends Zombie {
    public CriancaZombie(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura,0, nome, posX, posY);
        nomeTipo="Criança (Zombie)";
    }
    public String getImagePNG(){
        return "babyZombie.png";
    }

}
