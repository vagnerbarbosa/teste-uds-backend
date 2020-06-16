package com.vagnerdantas.enumeration;

/**
 * Copyright @author Vagner Dantas
 */
public enum FlavorEnum {

    MORANGO(1, "Morango"), BANANA(2, "Banana"), KIWI(3, "Kiwi");

    private final Integer key;
    private final String value;

    FlavorEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() { return key; }
    public String getValue() {
        return value;
    }
}
