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


// esta criatura move-se ate 3 casas para a frente, 1 para tras,
// 1 pa esquerda, e ate 2 para a direita
// nota: esta personagem tal como o vampiro e contrariamente ao idoso humano só joga de noite
// nota2 : filipe deixei o garlic como foto pk ya depois diz me qual o tema que achas mais bacano