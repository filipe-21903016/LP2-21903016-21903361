package pt.ulusofona.lp2.theWalkingDEISIGame;

public class PistolaWaltherPPK extends Equipamento {
    int bullets = 3;

    public PistolaWaltherPPK(int id, int posX, int posY) {
        super(id, 2, posX, posY);
        super.titulo = "Pistola Walther PPK";
        super.offensive = true;
    }


    @Override
    public String getInfo() {
        return titulo + " | " + bullets;
    }

    public String getImagePNG(){
        return "pistol.png";
    }

    @Override
    public boolean use() {

        if(bullets>0){
            bullets-=1;
            if(bullets==0){
                this.offensive=false;
            }
            uso++;
            return true;
        }
        return false;
    }
}
