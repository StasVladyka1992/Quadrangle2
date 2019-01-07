package com.vladyka.quadrangle.model.exception;

/**
 * Created by Vladyka Stas
 * on 26.12.2018 at 23:12
 **/
public class NoCoordinatesFoundException extends Exception {
    public NoCoordinatesFoundException() {
    }

    public NoCoordinatesFoundException(String message) {
        super(message);
    }

    public NoCoordinatesFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoCoordinatesFoundException(Throwable cause) {
        super(cause);
    }

    public NoCoordinatesFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
