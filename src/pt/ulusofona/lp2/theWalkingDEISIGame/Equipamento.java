package pt.ulusofona.lp2.theWalkingDEISIGame;


public abstract class Equipamento {
    protected String titulo;
    protected int id;
    protected int idTipo;
    protected int posX;
    protected int posY;

    protected boolean picked = false;
    protected boolean offensive;
    protected boolean defensive;

    public int getId() {
        return id;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public String getTitulo() {
        return titulo;
    }

    String getInfo() {
        return titulo;
    }

    abstract public String getImagePNG();

    public Equipamento(int id, int idTipo, int posX, int posY) {
        this.id = id;
        this.idTipo = idTipo;
        this.posX = posX;
        this.posY = posY;
    }

    public Equipamento(String titulo, int id, int idTipo, int posX, int posY) {
        this.titulo = titulo;
        this.id = id;
        this.idTipo = idTipo;
        this.posX = posX;
        this.posY = posY;
    }


    @Override
    public String toString() {
        return titulo;
    }

    public void setPicked() {
        this.picked=true;
    }

    public void setDropped(){
        this.picked= false;
    }

    public boolean isPicked() {
        return picked;
    }

    public boolean isOffensive() {
        return offensive;
    }

    public boolean isDefensive() {
        return defensive;
    }

    public boolean use(){
        //System.out.println(id+":"+titulo+" was used");
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        Equipamento equipamento = (Equipamento) obj;
        if(this.id==equipamento.getId()){
            return true;
        }
        return false;
    }
}
