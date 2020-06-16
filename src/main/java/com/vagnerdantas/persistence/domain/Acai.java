package com.vagnerdantas.persistence.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
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
    @Column(name = ACTION)
    private String action;
    @Column(name = CREATED_AT)
    private String createdAt;
    @Column(name = NUMBER_ISSUE)
    private String numberIssue;

    public Acai() {
        super();
    }

    @JsonCreator
    public Acai(@JsonProperty(ACTION) String action, @JsonProperty(CREATED_AT) String createdAt) {
        this.action = action;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getNumberIssue() {
        return numberIssue;
    }

    public void setNumberIssue(String numberIssue) {
        this.numberIssue = numberIssue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Acai)) return false;
        Acai event = (Acai) o;
        return Objects.equals(getId(), event.getId()) &&
                Objects.equals(getAction(), event.getAction()) &&
                Objects.equals(getCreatedAt(), event.getCreatedAt()) &&
                Objects.equals(getNumberIssue(), event.getNumberIssue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAction(), getCreatedAt(), getNumberIssue());
    }
}
