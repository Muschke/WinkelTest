package be.scruples.scruplesantwerpen.exceptions;

public class OngeldigeWoordkeuzeException extends RuntimeException{
    private static final long serielVersionUID = 1L;
    public OngeldigeWoordkeuzeException(String message) {
        super(message);
    }
}
