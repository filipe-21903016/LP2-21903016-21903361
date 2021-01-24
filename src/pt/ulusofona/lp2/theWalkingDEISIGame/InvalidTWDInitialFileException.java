package pt.ulusofona.lp2.theWalkingDEISIGame;

public class InvalidTWDInitialFileException extends Exception {
    public InvalidTWDInitialFileException() {
        super("Ficheiro Inicial Inválido");
    }

    public InvalidTWDInitialFileException(String message) {
        super(message);
    }
}
