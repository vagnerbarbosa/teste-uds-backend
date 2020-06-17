package com.vagnerdantas.persistence.domain;

import com.vagnerdantas.enumeration.AdditionalEnum;
import com.vagnerdantas.enumeration.FlavorEnum;
import com.vagnerdantas.enumeration.SizeEnum;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

/**
 * Copyright @author Vagner Dantas
 */
@Entity
@Table(name = Acai.ACAI_TABLE)
public class Acai {

    private static final long serialVersionUID = -6371541105996068355L;

    public static final String ID = "id";
    public static final String ACAI_TABLE = "tb_acai";

    @Id
    @Column(name = ID)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated
    private SizeEnum size;

    @Enumerated
    private FlavorEnum flavor;

    @Column
    private LocalTime preparationTime;

    @Column
    private BigDecimal total;

    @ElementCollection
    @Column(name="additional")
    private List<AdditionalEnum> additional;

    public Acai() { super(); }

    public Acai(Integer id, SizeEnum size, FlavorEnum flavor, LocalTime preparationTime, BigDecimal total, List<AdditionalEnum> additional) {
        this.id = id;
        this.size = size;
        this.flavor = flavor;
        this.preparationTime = preparationTime;
        this.total = total;
        this.additional = additional;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<AdditionalEnum> getAdditional() {
        return additional;
    }

    public void setAdditional(List<AdditionalEnum> additional) {
        this.additional = additional;
    }
}
