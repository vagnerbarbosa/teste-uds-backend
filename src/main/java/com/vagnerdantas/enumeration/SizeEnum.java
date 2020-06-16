package com.vagnerdantas.enumeration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Copyright @author Vagner Dantas
 */
public enum SizeEnum {

    PEQUENO(1, "Pequeno"), MEDIO(2, "Médio"), GRANDE(3, "Grande");

    private final Integer key;
    private final String value;

    SizeEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() { return key; }
    public String getValue() {
        return value;
    }
}
