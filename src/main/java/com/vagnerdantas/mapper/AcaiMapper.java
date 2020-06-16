package com.vagnerdantas.mapper;

import com.vagnerdantas.persistence.domain.Acai;
import com.vagnerdantas.persistence.domain.AcaiDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright @author Vagner Dantas
 */
public class AcaiMapper {

    private static final long serialVersionUID = 7659073175654466068L;

    private AcaiMapper() { super(); }

    public static AcaiDTO mapperToAcaiDTO(Acai event) {
        AcaiDTO acaiDTO = new AcaiDTO();
        return acaiDTO;
    }

    public static List<AcaiDTO> mapperAllToDTO(List<Acai> eventList) {
        return eventList.stream().map(AcaiMapper::mapperToAcaiDTO).collect(Collectors.toList());
    }
}
