package pt.ulusofona.lp2.theWalkingDEISIGame;

public class Zombie {
    String nome;
    String nomeEquipa = "OS MORTOS";
    int idCriatura;
    int posX;
    int posY;
    int equimentsDestroyed;
    //int idTipo = 0;


    public Zombie(int idCriatura, String nome, int posX, int posY) {
        this.idCriatura = idCriatura;
        this.nome = nome;
        this.posX = posX;
        this.posY = posY;
        this.equimentsDestroyed = 0;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    void destroyEquiment() {
        this.equimentsDestroyed++;
    }

    public int getId() {
        return this.idCriatura;
    }

    public String getImagePNG() {
        return "zombie.png";
    }

    public String toString() {
        /*Retorna uma String com a informação sobre a criatura.
        Sintaxe:
            “<ID> | <Tipo> | <Nome Equipa> | <Nome> <Equipamentos> @ (<x>,<y>)”
        Onde <Tipo> deve ser o nome por extenso do tipo (p.e. “Humano” ou “Zombie”).
        Onde <Equipamentos> deve ser:
            ● Se a criatura for um Humano: a quantidade de equipamentos apanhados pelo humano desde que o jogo começou;
        ● Se a criatura for um Zombie: a quantidade de equipamentos destruídos pelo zombie desde que o*/
        return idCriatura + " | Zombie | " + nomeEquipa + " | " + nome
                + " " + equimentsDestroyed + " @ (" + posX + ", " + posY + ")";
    }
}
