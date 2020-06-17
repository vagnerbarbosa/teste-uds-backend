package com.vagnerdantas.service;

import com.vagnerdantas.persistence.domain.Acai;
import com.vagnerdantas.persistence.domain.AcaiDTO;
import com.vagnerdantas.util.MessageResponseDTO;

/**
 * Copyright @author Vagner Dantas
 */
public interface AcaiService {

    MessageResponseDTO acaiPersist(AcaiDTO acai);

    Acai getAcai(Integer id);
}
