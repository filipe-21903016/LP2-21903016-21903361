package pt.ulusofona.lp2.theWalkingDEISIGame;

abstract class Zombie extends Creature {
    protected String nomeEquipa = "Os Outros";

    public Zombie(int idCriatura, int idType,String nome, int posX, int posY) {
        super(idCriatura,idType, nome, posX, posY);
        teamId=20;
    }

    @Override
    public boolean move(int xO,int yO,int xD, int yD){
        GameInfo gameInfo = GameInfo.getInstance();
        if(!isValidMove(xO, yO, xD, yD) || gameInfo.isDoorToSafeHaven(xD,yD)){
            return false;
        }
        int id = gameInfo.getElementId(xD,yD);
        if(id<0){
            Equipamento equipamento = gameInfo.getEquipmentById(id);
            //vampiro nao move para cabecas de alho
            // zombies nao podem mover para cima de veneno
            if(this.idType==4 && equipamento.getIdTipo()==5){ //Se é vampiro nao pode destruir alho
                return false;
            }
            /*//TODO no caso de um zombie nao poder destruir garrafas de veneno vazias alterar
            if(equipamento.getIdTipo()==8){
                Veneno veneno = (Veneno) equipamento;
                if(!veneno.isEmpty()){
                    return false;
                }
            }*/
            destroyEquiment();
            gameInfo.removeEquipment(equipamento);
        }
        if(id>0){
            Creature creature = gameInfo.getCreatureById(id);
            Vivo vivo = (Vivo) creature;
            Equipamento targetEquipment= vivo.getEquipment();

            if(vivo.isPoisoned()){
                return true;
            }
            if(vivo.getIdType()==9){ //Zombies are afraid of dogs
                return false;
            }

            if(idType==4 && vivo.isEquiped() && targetEquipment.getIdTipo()==5){ //Vampiro nao ataca quem tem cabecas de alho
                return false;
            }
            this.combat(vivo);
        }
        posX = xD;
        posY = yD;
        return true;
    }

    public boolean combat(Creature creature) { //Retorna true se houve transformacao
        Vivo target = (Vivo) creature;
        Equipamento targetEquipment = target.getEquipment();
        if (!target.isEquiped()
                || !targetEquipment.isDefensive()
                || targetEquipment.getIdTipo() == 4 && this.idType != 3 //Revista Maria vs Zombie Nao Idoso
                || target.getIdType() == 5 && targetEquipment.getIdTipo() == 1 && this.idType != 0) { //Crianca com espada vs Zombie Adulto
            target.turn();
            return true;
        }
        if (targetEquipment.isDefensive() || (targetEquipment.isDefensive() && targetEquipment.isOffensive())) {
            targetEquipment.use();
            return false;
        }
        if (targetEquipment.isOffensive()) {
            targetEquipment.use();
            GameInfo.getInstance().removeCreature(this);
            return false;
        }
        return false;
    }

    void destroyEquiment(){
        this.equipamentos++;
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
                    + " " + equipamentos + " @ RIP";
        }
        return idCriatura + " | " + nomeTipo + " | " + nomeEquipa + " | " + nome
                + " " + equipamentos + " @ (" + posX + ", " + posY + ")";
    }

}
