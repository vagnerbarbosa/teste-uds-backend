package com.vagnerdantas.enumeration;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Copyright @author Vagner Dantas
 */
public enum AdditionalEnum {
    @JsonProperty("GRANOLA")
    GRANOLA(1, "Granola"),
    @JsonProperty("PACOCA")
    PACOCA(2, "Paçoca"),
    @JsonProperty("LEITE_NINHO")
    LEITE_NINHO(3, "Leite Ninho");

    private final Integer key;
    private final String value;

    AdditionalEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() { return key; }
    public String getValue() {
        return value;
    }
}
