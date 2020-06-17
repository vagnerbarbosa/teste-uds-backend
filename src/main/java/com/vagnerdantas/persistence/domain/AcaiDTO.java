package com.vagnerdantas.persistence.domain;

import com.vagnerdantas.enumeration.FlavorEnum;
import com.vagnerdantas.enumeration.SizeEnum;

/**
 * Copyright @author Vagner Dantas
 */
public class AcaiDTO {

    private static final long serialVersionUID = 7752233227018841352L;

    private SizeEnum size;
    private FlavorEnum flavor;

    public AcaiDTO() {
        super();
    }

    public SizeEnum getSize() {
        return size;
    }

    public void setSize(SizeEnum size) {
        this.size = size;
    }

    public FlavorEnum getFlavor() {
        return flavor;
    }

    public void setFlavor(FlavorEnum flavor) {
        this.flavor = flavor;
    }
}
