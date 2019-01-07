package com.vladyka.quadrangle.model.exception;

/**
 * Created by Vladyka Stas
 * on 27.12.2018 at 2:01
 **/
public class NullReferenceException extends Exception {
    public NullReferenceException() {
    }

    public NullReferenceException(String message) {
        super(message);
    }

    public NullReferenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullReferenceException(Throwable cause) {
        super(cause);
    }

    public NullReferenceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
