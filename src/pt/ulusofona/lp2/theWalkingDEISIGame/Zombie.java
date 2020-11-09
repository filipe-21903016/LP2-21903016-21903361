package pt.ulusofona.lp2.theWalkingDEISIGame;

public class Zombie {
    int id;
    int idCriatura = 0;
    String nome;

    public int getId() {
        return this.id;
    }

    public String getImagePNG() {
        /*Deve devolver o nome do ficheiro de imagem
        (formato PNG) que representa a criatura.
        (As imagens a usar devem ser colocadas na pasta
        src/images e devem ter tamanho 50x50. As imagens
        devem ter fundo transparente para que se consiga
        ver se estão num quadrado branco ou preto).
        Caso os alunos não pretendam definir
        nenhuma imagem, a função pode
        simplesmente retornar null. Isto fará com
        que o visualizador use uma imagem
        pré-definida por omissão.*/
        return null;
    }

    public String toString() {
        /*Retorna uma String com a informação sobre a criatura.
        Sintaxe:
            “<ID> | <Tipo> | <Nome Equipa> | <Nome> <Equipamentos> @ (<x>,<y>)”
        Onde <Tipo> deve ser o nome por extenso do tipo (p.e. “Humano” ou “Zombie”).
        Onde <Equipamentos> deve ser:
            ● Se a criatura for um Humano: a quantidade de equipamentos apanhados pelo humano desde que o jogo começou;
        ● Se a criatura for um Zombie: a quantidade de equipamentos destruídos pelo zombie desde que o*/
        return null;
    }
}
