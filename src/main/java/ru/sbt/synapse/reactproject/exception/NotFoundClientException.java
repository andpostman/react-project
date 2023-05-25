package ru.sbt.synapse.reactproject.exception;

public class NotFoundClientException extends RuntimeException{
    public NotFoundClientException() {
        super("Пользователя не существует");
    }
}
