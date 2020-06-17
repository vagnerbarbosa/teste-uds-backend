package com.vagnerdantas.enumeration;

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
