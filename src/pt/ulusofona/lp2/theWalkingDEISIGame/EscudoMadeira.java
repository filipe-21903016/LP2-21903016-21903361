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
        uses-=1;
        if(uses==0){
            GameInfo gameInfo = GameInfo.getInstance();
            for(Creature c : gameInfo.getCreatures()){
                if(c.getTeamId() == gameInfo.getIdTeamVivos()){
                    Vivo vivo= (Vivo) c;
                    if(vivo.isEquiped() && vivo.getEquipment().getId()==this.id){
                        vivo.destroyEquipment();
                    }
                }
            }
        }
        return true;
    }
}
