package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.util.ArrayList;

public class InvalidTWDInitialFileException extends Exception {
    int nrCreatures;
    ArrayList<String> tempCreature = new ArrayList<>();
    String message;

    public InvalidTWDInitialFileException(int nrCreatures){
        this.nrCreatures = nrCreatures;
        this.message="Invalid number of Creatures: " + nrCreatures;
    }

    public InvalidTWDInitialFileException(ArrayList<String> creatureData){
        this.tempCreature = creatureData;
        this.message = "Invalid creature description";
    }

    public boolean validNrOfCreatures(){
        return nrCreatures>=2;
    }

    public boolean validCreatureDefinition(){
        //TODO implementar testes para esta fncao
        for(String line : tempCreature) {
            String[] data = line.split(" : ");
            if(data.length != 5){
                return false;
            }
        }
        return true;
    }

    public String getErroneousLine(){
        //TODO implementar testes para esta fncao
        if(!validCreatureDefinition()){
            for(String line : tempCreature){
                String[] data = line.split(" : ");
                if(data.length!=5){
                    return line;
                }
            }
        }
        return "";
    }

}
