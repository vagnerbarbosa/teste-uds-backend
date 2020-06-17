package com.vagnerdantas.service;

import com.vagnerdantas.enumeration.AdditionalEnum;
import com.vagnerdantas.persistence.domain.Acai;
import com.vagnerdantas.persistence.domain.AcaiDTO;
import com.vagnerdantas.util.MessageResponseDTO;

import java.util.List;

/**
 * Copyright @author Vagner Dantas
 */
public interface AcaiService {

    MessageResponseDTO acaiPersist(AcaiDTO acai);

    MessageResponseDTO additionalPersist(Integer idAcai, List<AdditionalEnum> additional);

    Acai getAcai(Integer id);

}
