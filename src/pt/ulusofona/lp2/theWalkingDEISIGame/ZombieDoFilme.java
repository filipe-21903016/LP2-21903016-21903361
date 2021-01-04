package pt.ulusofona.lp2.theWalkingDEISIGame;

public class ZombieDoFilme extends Zombie{
    public ZombieDoFilme(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura, 10, nome, posX, posY);
        nomeTipo = "Zombie do Filme";
    }

    public String getImagePNG(){
        return "oceanMan.png";
    }
}