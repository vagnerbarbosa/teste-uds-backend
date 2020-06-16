package com.vagnerdantas.util;

import java.io.Serializable;
import java.util.Objects;

/**
 * Copyright @author Vagner Dantas
 */
public class MessageResponseDTO implements Serializable {

    private static final long serialVersionUID = 424114329492787151L;

    private String status;
    private String message;

    public MessageResponseDTO() {
        super();
    }

    public MessageResponseDTO(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MessageResponseDTO)) return false;
        MessageResponseDTO that = (MessageResponseDTO) o;
        return getStatus() == that.getStatus() &&
                Objects.equals(getMessage(), that.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatus(), getMessage());
    }
}
