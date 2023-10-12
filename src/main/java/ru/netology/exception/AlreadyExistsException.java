package ru.netology.exception;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String r) {
        super(r);
    }
}
