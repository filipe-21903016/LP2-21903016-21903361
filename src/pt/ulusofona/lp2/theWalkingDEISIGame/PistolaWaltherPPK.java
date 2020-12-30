package pt.ulusofona.lp2.theWalkingDEISIGame;

public class PistolaWaltherPPK extends Equipamento {
    int bullets = 3;

    public PistolaWaltherPPK(int id, int posX, int posY) {
        super(id, 2, posX, posY);
        super.titulo = "Pistola Walther PPK";
        super.offensive = true;
    }


    @Override
    String getInfo() {
        return titulo + " | " + bullets;
    }

    public String getImagePNG(){
        return "pistol.png";
    }

    @Override
    public boolean use() {
        if(bullets>0){
            bullets-=1;
            return true;
        }
        //this.offensive=false;
        return false;
    }
}
