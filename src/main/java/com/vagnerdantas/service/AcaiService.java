package com.vagnerdantas.service;

import com.vagnerdantas.persistence.domain.AcaiDTO;
import com.vagnerdantas.util.MessageResponseDTO;

import java.util.List;

/**
 * Copyright @author Vagner Dantas
 */
public interface AcaiService {

    MessageResponseDTO acaiPersist(String message);

    List<AcaiDTO> getAll(String id);
}
