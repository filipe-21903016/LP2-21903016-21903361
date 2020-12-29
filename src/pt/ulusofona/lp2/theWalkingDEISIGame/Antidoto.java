package pt.ulusofona.lp2.theWalkingDEISIGame;

public class Antidoto extends Equipamento {
    boolean used;

    public Antidoto(int id, int posX, int posY) {
        super(id, 9, posX, posY);
        super.titulo = "Antídoto";
        super.defensive= true;
    }

    public String getImagePNG(){
        return "antidote.png";
    }

    public boolean isEmpty(){
        return used;
    }
    /*
    @Override
    public boolean use(){
        /*if (uses == 0){
            return false;
        }
        else {
            GameInfo gameInfo = GameInfo.getInstance();
            for (Creature creature : gameInfo.getCreatures()){
                if (creature.getTeamId() == gameInfo.getIdTeamVivos()){
                    Vivo vivo = (Vivo) creature;
                    if (vivo.isEquiped() && vivo.getEquipment().getId() == this.id){
                        if (!poisoned){
                            return false;
                        }
                    }
                }
            }
        }
        poisoned = false;
        uses = 0;
        return true;


    }*/
    @Override
    public boolean use() {
        if(!used){
            used=true;
            return true;
        }
        return false;
    }
}
