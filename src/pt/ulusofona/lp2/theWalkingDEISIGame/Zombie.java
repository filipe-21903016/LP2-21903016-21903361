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
            if(this.idType==4 && equipamento.getIdTipo()==5){
                return false;
            }
            //TODO no caso de um zombie nao poder destruir garrafas de veneno vazias alterar
            if(equipamento.getIdTipo()==8){
                Veneno veneno = (Veneno) equipamento;
                if(!veneno.isEmpty()){
                    return false;
                }
            }
            destroyEquiment();
            gameInfo.removeEquipment(equipamento);
        }
        if(id>0){
            Creature creature = gameInfo.getCreatureById(id);
            Vivo vivo = (Vivo) creature;

            Equipamento targetEquipment= vivo.getEquipment();

            if(vivo.isPoisoned()){
                return false;
            }
            if(vivo.getIdType()==9){ //Zombies are afraid of dogs
                return false;
            }
            if(idType==4 && vivo.isEquiped() && targetEquipment.getIdTipo()==5){ //Vampiro nao ataca quem tem cabecas de alho
                return false;
            }

            if(!vivo.isEquiped() //TODO THIS IS UGLY,NEEDS TO BE REFINED
                    || (this.getIdType() != 3 && targetEquipment.getIdTipo() == 4) //revista maria only protects against idosos zombies
                    || targetEquipment.getIdTipo() == 5 // cabecas de alho so protegem contra ataques de vampiro
                    || targetEquipment.getIdTipo()==8   // se humano nao esta envenenado entao o frasco de veneno nao o protege
                    || targetEquipment.getIdTipo() == 9 // o frasco de antidoto nao protege o humano
            ){
                //transformar vivo em zombie
                vivo.turn();
                return true;
            }

            if(targetEquipment.isOffensive()){
                if(targetEquipment.isDefensive()){ //beskar helmet
                    return true;
                }
                if(vivo.getIdType()==5 && targetEquipment.getIdTipo()==1 && this.idType!=0){ //mesmo q a crianca tenha equipamento ofensivo este so e eficaz em crianca zombie
                    vivo.turn();
                    return true;
                }
                if(vivo.getEquipment().use()){ //TODO possible error
                    gameInfo.removeCreature(this);
                }else{
                    vivo.turn();
                }
                return true;
            }
            this.combat(vivo);
            return true;
        }
        posX = xD;
        posY = yD;
        return true;
    }

    @Override
    public boolean combat(Creature creature) {
        Vivo target = (Vivo) creature;
        Equipamento targetEquipment= target.getEquipment();
        if(targetEquipment.use()) { //humano usa equipamento de defesa
            return false;
        }

        return true;
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
