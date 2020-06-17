package com.vagnerdantas.persistence.domain;

import com.vagnerdantas.enumeration.FlavorEnum;
import com.vagnerdantas.enumeration.SizeEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Objects;

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

    public Acai() { super(); }

    public Acai(Integer id, SizeEnum size, FlavorEnum flavor, LocalTime preparationTime, BigDecimal total) {
        this.id = id;
        this.size = size;
        this.flavor = flavor;
        this.preparationTime = preparationTime;
        this.total = total;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Acai)) return false;
        Acai acai = (Acai) o;
        return Objects.equals(getId(), acai.getId()) &&
                getSize() == acai.getSize() &&
                getFlavor() == acai.getFlavor() &&
                Objects.equals(getPreparationTime(), acai.getPreparationTime()) &&
                Objects.equals(getTotal(), acai.getTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSize(), getFlavor(), getPreparationTime(), getTotal());
    }
}
