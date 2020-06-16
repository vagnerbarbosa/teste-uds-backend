package com.vagnerdantas.persistence.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vagnerdantas.enumeration.FlavorEnum;
import com.vagnerdantas.enumeration.SizeEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Copyright @author Vagner Dantas
 */
@Entity
@Table(name = Acai.ACAI_TABLE)
public class Acai {

    private static final long serialVersionUID = -6371541105996068355L;

    public static final String ID = "id";
    public static final String ACTION = "action";
    public static final String CREATED_AT = "created_at";
    public static final String NUMBER_ISSUE = "number_issue";
    public static final String ACAI_TABLE = "tb_acai";

    @Id
    @Column(name = ID)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated
    private SizeEnum size;

    @Enumerated
    private FlavorEnum flavor;

    public Acai() { super(); }

    public Acai(Integer id, SizeEnum size, FlavorEnum flavor) {
        this.id = id;
        this.size = size;
        this.flavor = flavor;
    }

    public static String getID() {
        return ID;
    }

    public static String getACTION() {
        return ACTION;
    }

    public static String getCreatedAt() {
        return CREATED_AT;
    }

    public static String getNumberIssue() {
        return NUMBER_ISSUE;
    }

    public static String getAcaiTable() {
        return ACAI_TABLE;
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
}
