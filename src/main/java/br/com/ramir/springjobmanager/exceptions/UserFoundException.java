package br.com.ramir.springjobmanager.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("Usuário já existe");
    }
}
