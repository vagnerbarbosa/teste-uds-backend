package com.vagnerdantas.persistence.domain;

import java.util.Objects;

/**
 * Copyright @author Vagner Dantas
 */
public class AcaiDTO {

    private static final long serialVersionUID = 7752233227018841352L;

    private String action;
    private String created_at;

    public AcaiDTO() {
        super();
    }

    public AcaiDTO(String action, String created_at) {
        this.action = action;
        this.created_at = created_at;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AcaiDTO)) return false;
        AcaiDTO acaiDTO = (AcaiDTO) o;
        return Objects.equals(getAction(), acaiDTO.getAction()) &&
                Objects.equals(getCreated_at(), acaiDTO.getCreated_at());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAction(), getCreated_at());
    }
}
