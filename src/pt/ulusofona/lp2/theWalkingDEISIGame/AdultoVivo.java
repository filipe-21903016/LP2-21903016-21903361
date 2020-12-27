package pt.ulusofona.lp2.theWalkingDEISIGame;

public class AdultoVivo extends Vivo {
    public AdultoVivo(int idCriatura, String nome, int posX, int posY) {
        super(idCriatura,6, nome, posX, posY);
    }

    @Override
    public boolean isValidMove(int xO, int yO, int xD, int yD) {
        if (xO == xD && yO == yD) {
            return false;
        }
        return (xD == xO && yD >= yO - 2 && yD <= yO + 2) || (yD == yO && xD >= xO - 2 && xD <= xO + 2) ||
                (xD == yD && xD <= xO + 2 && xD >= xO - 2) || (xD == -1 * yD && xD <= xO + 2 && xD >= xO - 2);

    }

    @Override
    public boolean move(int xD, int yD) {
        posX = xD;
        posY = yD;
        return true;
    }

    public String getImagePNG(){
        return "steve.png";
    }
}
