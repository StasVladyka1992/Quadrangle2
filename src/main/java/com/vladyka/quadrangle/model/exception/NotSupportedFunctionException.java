package com.vladyka.quadrangle.model.exception;

/**
 * Created by Vladyka Stas
 * on 27.12.2018 at 1:02
 **/
public class NotSupportedFunctionException extends Exception {
    public NotSupportedFunctionException() {
    }

    public NotSupportedFunctionException(String message) {
        super(message);
    }

    public NotSupportedFunctionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSupportedFunctionException(Throwable cause) {
        super(cause);
    }

    public NotSupportedFunctionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
