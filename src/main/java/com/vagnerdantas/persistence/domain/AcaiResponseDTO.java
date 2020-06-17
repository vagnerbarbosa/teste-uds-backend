package com.vagnerdantas.persistence.domain;

import java.math.BigDecimal;
import java.time.LocalTime;

/**
 * Copyright @author Vagner Dantas
 */
public class AcaiResponseDTO {

    private static final long serialVersionUID = -5184909822107324825L;

    private String size;
    private String flavor;
    private String additionals;
    private LocalTime preparationTime;
    private BigDecimal total;

    public AcaiResponseDTO() { super(); }

    public AcaiResponseDTO(String size, String flavor, String additionals, LocalTime preparationTime, BigDecimal total) {
        this.size = size;
        this.flavor = flavor;
        this.additionals = additionals;
        this.preparationTime = preparationTime;
        this.total = total;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getAdditionals() {
        return additionals;
    }

    public void setAdditionals(String additionals) {
        this.additionals = additionals;
    }

    public LocalTime getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(LocalTime preparationTime) {
        this.preparationTime = preparationTime;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
