package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TWDGameManager {
    public TWDGameManager() {
    }

    public boolean startGame(File ficheiroInicial){
        /*Deve fazer a leitura do ficheiro de texto e
        carregar para a memória a informação relevante.
        Esta função deve devolver true caso a
        leitura do ficheiro decorra sem problemas,
        e false em caso contrário.*/

        try{
            Scanner scanner = new Scanner(ficheiroInicial);
            ArrayList<String> lines= new ArrayList<>();

            //Scans all lines to list
            while(scanner.hasNextLine()){
                lines.add(scanner.nextLine());
            }





            scanner.close();

        }catch (FileNotFoundException e) {
            return false;
        }
        return false;
    }
    public int[] getWorldSize(){
        /*Deve devolver o tamanho do bairro,
        conforme lido do ficheiro respectivo.
        Na posição 0 do array deve ser devolvido o
        número de linhas e na posição 1 deve ser
        devolvido o número de colunas.*/
        return new int[]{};
    }
    public int getInitialTeam(){
        /*Devolve o ID da equipa que vai jogar no
        primeiro turno do jogo.*/
        return 0;
    }
    public List<Humano> getHumans(){
        /*Devolve uma lista com todos os objectos
        Humano que existem no jogo.*/
        return new ArrayList<Humano>();
    }
    public List<Zombie> getZombies(){
        /*Devolve uma lista com todos os objectos
        Zombie que existem no jogo.*/
        return new ArrayList<Zombie>();
    }
    public boolean move(int xO, int yO, int xD, int yD){
        /*Deve tentar executar uma jogada,
        considerando que (xO, yO) representa a
        origem a jogada e (xD, yD) representa o
        destino da jogada.
        Caso a jogada seja válida, deve executar a
        mesma e devolver true. Em caso
        contrário, deve devolver false.*/
        return false;
    }
    public boolean gameIsOver(){
        /*Deve devolver true caso já tenha sido
        alcançada uma das condições de paragem
        do jogo e false em caso contrário.*/
        return false;
    }
    public List<String> getAuthors(){
        /*Devolve uma lista de Strings com os
        nomes dos autores do projecto.
        Esta informação será usada para mostrar o
        conteúdo da janela que aparece ao
        carregar no botão de “Créditos”.*/
        return new ArrayList<String>();
    }
    public int getCurrentTeamId(){
        /*Deve devolver o ID da equipa que está
        activa no turno actual.*/
        return 0;
    }
    public int getElementId(int x, int y){
        /*Deve devolver o ID do objecto/elemento
        que se encontra na posição indicada pelas
        coordenadas (x,y) passadas por
        argumento.
        Por objecto/elemento entende-se: criatura ou tesouro.
        Caso não exista nenhuma criatura ou
        tesouro na posição indicada, o método
        deve devolver o valor 0 (zero) que
        representa o vazio.*/
        return 0;
    }

    public List<String> getSurvivors(){
        /*Devolve uma lista de Strings que
        representam as criaturas sobreviventes do
        jogo, conforme descrito na secção dos
        “Resultados da execução …”.
        Este método não pode devolver null.
        Caso não calculem a informação
        respectiva, devem devolver uma lista
        vazia.*/
        return new ArrayList<String>();
    }

    public boolean isDay(){
        /*Dever retornar true caso o turno actual
        corresponda a um turno diurno e false
        caso o turno actual corresponda um turno
        nocturno.*/
        return false;
    }

    public boolean hasEquipment(int creatureId, int equipmentTypeId){
        /*Deve retornar true caso a criatura
        identificada pelo 1º argumento tenha em
        sua posse um equipamento do tipo cujo ID
        for passado como 2º argumento.
        Em caso contrário, deve retornar false.*/
        return false;
    }




}
