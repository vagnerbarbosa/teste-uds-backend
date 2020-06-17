package com.vagnerdantas.mapper;

import com.vagnerdantas.enumeration.AdditionalEnum;
import com.vagnerdantas.persistence.domain.Acai;
import com.vagnerdantas.persistence.domain.AcaiDTO;
import com.vagnerdantas.persistence.domain.AcaiResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright @author Vagner Dantas
 */
public class AcaiMapper {

    private static final long serialVersionUID = 7659073175654466068L;

    private AcaiMapper() { super(); }

    public static Acai mapperToAcai(AcaiDTO dto) {
        Acai acai = new Acai();
        acai.setFlavor(dto.getFlavor());
        acai.setSize(dto.getSize());
        return acai;
    }

    public static AcaiResponseDTO mapperToAcaiResponseDTO(Acai acai) {
        AcaiResponseDTO dto = new AcaiResponseDTO();
        if (acai.getSize() != null) {
            dto.setSize(acai.getSize().getValue());
        }
        if (acai.getFlavor() != null) {
            dto.setFlavor(acai.getFlavor().getValue());
        }
        List<String> additionals = acai.getAdditional().stream().map(AdditionalEnum::getValue).collect(Collectors.toList());
        if (!additionals.isEmpty()) {
            dto.setAdditionals(additionals.stream().map(Object::toString).collect(Collectors.joining(" / ", "", "")));
        }
        if (acai.getPreparationTime() != null) {
            dto.setPreparationTime(acai.getPreparationTime());
        }
        if (acai.getTotal() != null) {
            dto.setTotal(acai.getTotal());
        }
        return dto;
    }

}
