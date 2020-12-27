package pt.ulusofona.lp2.theWalkingDEISIGame;

abstract class Zombie extends Creature {
    protected String nomeEquipa = "Os Outros";
    protected int equipmentsDestroyed;

    public Zombie(int idCriatura, int idType,String nome, int posX, int posY) {
        super(idCriatura,idType, nome, posX, posY);
        teamId=20;
    }

    void destroyEquiment(){
        this.equipmentsDestroyed++;
    }

    public String getImagePNG() {
        return "zombie.png";
    }

    public int getTeamId() {
        return teamId;
    }

    @Override
    public String toString() {
        if(dead){
            return idCriatura + " | "+ nomeTipo +" | " + nomeEquipa + " | " + nome
                    + " " + equipmentsDestroyed + " @ RIP";
        }
        return idCriatura + " | " + nomeTipo + " | " + nomeEquipa + " | " + nome
                + " " + equipmentsDestroyed + " @ (" + posX + ", " + posY + ")";
    }
}
