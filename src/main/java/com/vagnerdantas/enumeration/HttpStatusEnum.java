package com.vagnerdantas.enumeration;

/**
 * Copyright @author Vagner Dantas
 */
public enum HttpStatusEnum {

    OK(200),
    CREATED(201),
    BAD_REQUEST(400),
    NO_CONTENT(204),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    private Integer code;

    HttpStatusEnum(Integer id) {
        this.code = id;
    }

    public Integer getCode() {
        return code;
    }
}
