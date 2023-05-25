package ru.sbt.synapse.reactproject.exception;

public class NotFoundProductException extends RuntimeException {
    public NotFoundProductException() {
        super("Товара не существует");
    }
}
