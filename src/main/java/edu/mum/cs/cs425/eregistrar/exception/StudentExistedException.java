package edu.mum.cs.cs425.eregistrar.exception;

public class StudentExistedException extends RuntimeException {
    public StudentExistedException(String message) {
        super(message);
    }
}