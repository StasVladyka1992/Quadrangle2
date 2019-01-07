package com.vladyka.quadrangle.model.exception;

/**
 * Created by Vladyka Stas
 * on 28.12.2018 at 2:01
 **/
public class NotAQuadrangleException extends Exception {
    public NotAQuadrangleException() {
    }

    public NotAQuadrangleException(String message) {
        super(message);
    }

    public NotAQuadrangleException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAQuadrangleException(Throwable cause) {
        super(cause);
    }

    public NotAQuadrangleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
