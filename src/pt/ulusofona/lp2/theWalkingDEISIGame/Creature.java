package pt.ulusofona.lp2.theWalkingDEISIGame;


import java.util.Comparator;

public abstract class Creature{
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

    public abstract boolean move(int xO, int yO, int xD, int yD);

    public abstract String getImagePNG();

    @Override
    public String toString() {
        return "";
    }

    private boolean isBlocked(int x, int y) {
        GameInfo gameInfo = GameInfo.getInstance();
        if (gameInfo.getElementId(x, y) != 0 || gameInfo.isDoorToSafeHaven(x, y)) {
            return true;
        }
        return false;
    }

    private boolean isPathBlocked(int xO, int yO, int xD, int yD) {
        GameInfo gameInfo = GameInfo.getInstance();
        //Verticais
        if (xO == xD) {
            if (yO > yD) {
                //destino esta em cima
                for (int y = yO - 1; y > yD; y--) {
                    if (isBlocked(xD, y)) {
                        return true;
                    }
                }
            } else {
                //destino esta em baixo
                for (int y = yO + 1; y < yD; y++) {
                    if (isBlocked(xD, y)) {
                        return true;
                    }
                }
            }
            return false;
        }
        //Horizontais
        if (yO == yD) {
            if (xO > xD) {
                //destino esta a esquerda
                for (int x = xO - 1; x > xD; x--) {
                    if (isBlocked(x, yD)) {
                        return true;
                    }
                }
            } else {
                //destino esta a direita
                for (int x = xO + 1; x < xD; x++) {
                    if (isBlocked(x, yD)) {
                        return true;
                    }
                }
            }
            return false;
        }
        //Diagonais
        int xOffset = xD - xO;
        int yOffset = yD - yO;
        if (xOffset > 0 && yOffset < 0) {
            //diagonal cima direita
            for (int x = xO + xOffset - 1, y = yO + yOffset + 1; x > xO && y < yO; x--, y++) {
                if (isBlocked(x, y)) {
                    return true;
                }
            }
        }
        if (xOffset < 0 && yOffset < 0) {
            //diagonal cima esquerda
            for (int x = xO + xOffset + 1, y = yO + yOffset + 1; x < xO && y < yO; x++, y++) {
                if (isBlocked(x, y)) {
                    return true;
                }
            }
        }
        if (xOffset < 0 && yOffset > 0) {
            //diagonal baixo esquerda
            for (int x = xO + xOffset + 1, y = yO + yOffset - 1; x < xO && y > yO; x++, y--) {
                if (isBlocked(x, y)) {
                    return true;
                }
            }
        }
        if (xOffset > 0 && yOffset > 0) {
            //diagonal baixo direita
            for (int x = xO + xOffset -1 , y = yO + yOffset -1 ; x > xO && y > yO; x--, y--) {
                if (isBlocked(x, y)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean isValidMove(int xO, int yO, int xD, int yD) {
        GameInfo gameInfo = GameInfo.getInstance();
        //Verificar se na casa de destino ja se encontra uma criatuta do mesmo tipo da casa de origem
        //Pr exemplo um zombie nao se pode mover para uma casa que tenha um zombie
        int elementId = gameInfo.getElementId(xD, yD);
        if (elementId > 0 && gameInfo.getTeamIdByCreatureId(elementId) == this.teamId
                || isPathBlocked(xO, yO, xD, yD)) {
            return false;
        }

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
                if ((xO == xD && yO == yD) || !gameInfo.isDay()) {
                    return false;
                }
                return (xD == xO && yD <= yO + 1 && yD >= yO - 1) /*VERTICAL*/
                        || (yD == yO && xD <= xO + 1 && xD >= xO - 1); /*HORIZONTAL*/
            }
            // Zombie do Filme
            case 10: {
                if ((xO == xD && yO == yD) || gameInfo.isDay()){
                    return false;
                }
                return (xD == xO && yD >= yO - 3 && yD <= yO + 1) /*VERTICAL*/
                        || (yD == yO && xD <= xO + 2 && xD >= xO - 1); /*HORIZONTAL*/
            }
            default:
                throw new IllegalArgumentException("Unknown Creature Type Id: " + idType);
        }
    }

    public void setDead(){
        dead=true;
    }

    @Override
    public boolean equals(Object obj) {
        Creature creature = (Creature) obj;
        return this.idCriatura==creature.getId();
    }

    public boolean isVivo(){
        return teamId==10;
    }


}
