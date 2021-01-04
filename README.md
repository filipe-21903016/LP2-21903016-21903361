The Walking Deisi
#LP2-21903016-21903361
![](diagrama.png?raw=true "Diagrama UML")

---

A construção do nosso projeto consiste na criação de duas factories (Creaturas e Equipamentos)
e de um singleton (GameInfo), para guardar os dados do jogo, no momento em que é instanciado.

Decidimos criar também uma classe para tipo de equipamento e para cada tipo de criatura de 
forma a organizar melhor o código

Dividimos o projeto em 4 packages, um com as imagens que foram personalizadas, outro com o package
pedido pelo professor, um so com testes Junits e outro com varios ficheiros de teste que representam
alguns casos possiveis que tivemos em conta, para tentar "cobrir" maior parte do código

---

Video do funcionamento do projeto : https://www.youtube.com/watch?v=yNtuRxiGSnY&feature=youtu.be

---

A criatura implementada por nós não se pode mover em direções colaterais, pode-se mover ate 3 posições para cima
, 2 para a direita, 1 para a esquerda e 1 para trás, em qualquer turno.

A nossa criatura foi baseada no filme creature of the black lagoon
 (https://en.wikipedia.org/wiki/Creature_from_the_Black_Lagoon)
 
Quanto aos testes da respectiva criatura, encontram-se no package Test, na classe TestZombieDoFilme



