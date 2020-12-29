package pt.ulusofona.lp2.theWalkingDEISIGame;

public class Antidoto extends Equipamento {
    boolean poisoned;
    int uses = 1 ;
    public Antidoto(int id, int posX, int posY) {
        super(id, 9, posX, posY);
        super.titulo = "Antídoto";
        super.defensive= true;
    }

    public String getImagePNG(){
        return "antidote.png";
    }

    public boolean isEmpty(){
        return uses==0;
    }

    public boolean isPoisoned() {return poisoned;}

    @Override
    public boolean use(){
        if (uses == 0){
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
    }
}
