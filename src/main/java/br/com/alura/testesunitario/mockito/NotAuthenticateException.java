package br.com.alura.testesunitario.mockito;

public class NotAuthenticateException extends Exception {
    public NotAuthenticateException() {
        super("Could not authenticate!");
    }
}
