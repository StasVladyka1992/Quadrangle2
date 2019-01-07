package com.vladyka.quadrangle.model.exception;

/**
 * Created by Vladyka Stas
 * on 26.12.2018 at 22:55
 **/
public class FileReadingException extends  Exception{
    public FileReadingException() {
    }

    public FileReadingException(String message) {
        super(message);
    }

    public FileReadingException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileReadingException(Throwable cause) {
        super(cause);
    }

    public FileReadingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
