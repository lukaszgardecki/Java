package pl.mojastrona.shortener.link.dto;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException() {
        super("wrong password");
    }
}
