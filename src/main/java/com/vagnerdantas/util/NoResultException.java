package com.vagnerdantas.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Copyright @author Vagner Dantas
 */
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class NoResultException extends RuntimeException {

    private static final long serialVersionUID = 1497780195967261624L;

    public NoResultException(String message, Throwable cause) {
        super(message, cause);
    }
}
