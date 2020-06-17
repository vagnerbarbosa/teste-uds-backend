package com.vagnerdantas.service;

import com.vagnerdantas.enumeration.AdditionalEnum;
import com.vagnerdantas.persistence.domain.AcaiDTO;
import com.vagnerdantas.persistence.domain.AcaiResponseDTO;
import com.vagnerdantas.util.MessageResponseDTO;

import java.util.List;

/**
 * Copyright @author Vagner Dantas
 */
public interface AcaiService {

    MessageResponseDTO acaiPersist(AcaiDTO acai);

    MessageResponseDTO additionalPersist(Integer idAcai, List<AdditionalEnum> additional);

    AcaiResponseDTO getAcai(Integer id);

}
