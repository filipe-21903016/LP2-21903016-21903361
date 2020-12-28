package pt.ulusofona.lp2.theWalkingDEISIGame;

public abstract class Creature {
    protected int idCriatura;
    protected int idType;
    protected String nome;
    protected int posX;
    protected int posY;
    protected int teamId;
    protected String nomeTipo;
    protected boolean dead;
    protected int equipamentos;


    public Creature(int idCriatura, int idType, String nome, int posX, int posY) {
        this.idCriatura = idCriatura;
        this.idType = idType;
        this.nome = nome;
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getId() {
        return this.idCriatura;
    }

    public int getIdType() {
        return idType;
    }

    public String getNome() {
        return nome;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setCoordinates(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    public abstract boolean move(int xO, int yO, int xD, int yD);

    public abstract String getImagePNG();

    @Override
    public String toString() {
        return "";
    }

    protected boolean isValidMove(int xO, int yO, int xD, int yD) {
        switch (idType) {
            //Adulto
            case 1:
            case 6: {
                if (xO == xD && yO == yD) {
                    return false;
                }
                int xOffset = xD - xO;
                int yOffset = yD - yO;
                return (xD == xO && yD <= yO + 2 && yD >= yO - 2) /*VERTICAL*/
                        || (yD == yO && xD <= xO + 2 && xD >= xO - 2) /*HORIZONTAL*/
                        || (Math.abs(xOffset) == Math.abs(yOffset) && Math.abs(xOffset) < 3 && Math.abs(yOffset) < 3); /*DIAGONAIS*/
            }
            //Crianca/Idoso Zombie
            case 0:
            case 3:
            case 5: {
                if (xO == xD && yO == yD) {
                    return false;
                }
                return (xD == xO && yD <= yO + 1 && yD >= yO - 1) /*VERTICAL*/
                        || (yD == yO && xD <= xO + 1 && xD >= xO - 1); /*HORIZONTAL*/
            }
            //Militar
            case 2:
            case 7: {
                if (xO == xD && yO == yD) {
                    return false;
                }
                int xOffset = xD - xO;
                int yOffset = yD - yO;
                return (xD == xO && yD <= yO + 3 && yD >= yO - 3) /*VERTICAL*/
                        || (yD == yO && xD <= xO + 3 && xD >= xO - 3) /*HORIZONTAL*/
                        || (Math.abs(xOffset) == Math.abs(yOffset) && Math.abs(xOffset) < 4 && Math.abs(yOffset) < 4); /*DIAGONAIS*/
            }
            //Zombie Vampiro
            case 4: {
                GameInfo gameInfo = GameInfo.getInstance();
                if ((xO == xD && yO == yD) || gameInfo.isDay()) {
                    return false;
                }
                int xOffset = xD - xO;
                int yOffset = yD - yO;
                return (xD == xO && yD <= yO + 2 && yD >= yO - 2) /*VERTICAL*/
                        || (yD == yO && xD <= xO + 2 && xD >= xO - 2) /*HORIZONTAL*/
                        || (Math.abs(xOffset) == Math.abs(yOffset) && Math.abs(xOffset) < 3
                        && Math.abs(yOffset) < 3); /*DIAGONAIS*/
            }
            //Cao
            case 9: {
                if (xO == xD && yO == yD) {
                    return false;
                }
                int xOffset = xD - xO;
                int yOffset = yD - yO;
                return (Math.abs(xOffset) == Math.abs(yOffset) && Math.abs(xOffset) < 3 && Math.abs(yOffset) < 3);
                /*DIAGONAIS*/
            }
            //Idoso Vivo
            case 8: {
                GameInfo gameInfo = GameInfo.getInstance();
                if ((xO == xD && yO == yD) || !gameInfo.isDay()) {
                    return false;
                }
                return (xD == xO && yD <= yO + 1 && yD >= yO - 1) /*VERTICAL*/
                        || (yD == yO && xD <= xO + 1 && xD >= xO - 1); /*HORIZONTAL*/
            }
            default:
                throw new IllegalArgumentException("Unknown Creature Type Id: " + idType);
        }
    }
}
