package pt.ulusofona.lp2.theWalkingDEISIGame;

import java.util.ArrayList;

public class InvalidTWDInitialFileException extends Exception {
    int nrCreatures;
    ArrayList<String> tempCreature = new ArrayList<>();


    public InvalidTWDInitialFileException(int nrCreatures, ArrayList<String> creatureData){
        this.tempCreature = creatureData;
        this.nrCreatures = nrCreatures;
    }

    public boolean validNrOfCreatures(){
        return nrCreatures>=2;
    }

    public boolean validCreatureDefinition(){
        for(String line : tempCreature) {
            String[] data = line.split(" : ");
            if(data.length != 5){
                return false;
            }
        }
        return true;
    }

    public String getErroneousLine(){
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
