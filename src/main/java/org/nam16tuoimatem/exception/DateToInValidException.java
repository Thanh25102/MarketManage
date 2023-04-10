package org.nam16tuoimatem.exception;

public class DateToInValidException extends Exception {

    public DateToInValidException() {
        super("Date to must be < date from");
    }

    public DateToInValidException(String message) {
        super(message);
    }
}
