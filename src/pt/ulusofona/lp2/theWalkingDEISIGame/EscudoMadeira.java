package pt.ulusofona.lp2.theWalkingDEISIGame;

public class EscudoMadeira extends Equipamento {
    int uses = 1;
    boolean buffed=false;
    public EscudoMadeira(int id, int posX, int posY) {
        super(id, 0, posX, posY);
        super.titulo = "Escudo de Madeira";
        super.defensive = true;
    }

    @Override
    String getInfo() {
        return titulo + " | " + uses;
    }

    public String getImagePNG(){
        return "shield.png";
    }

    public void militaryBuff() {
        uses=2;
        buffed=true;
    }

    public boolean isBuffed(){
        return buffed;
    }

    @Override
    public boolean use() {
        if(uses>0){
            uses-=1;
            if(uses==0){
                this.defensive=false;
            }
            return true;
        }
        return false;
    }
}
