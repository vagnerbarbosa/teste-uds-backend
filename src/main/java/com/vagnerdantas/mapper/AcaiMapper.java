package com.vagnerdantas.mapper;

import com.vagnerdantas.persistence.domain.Acai;
import com.vagnerdantas.persistence.domain.AcaiDTO;

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
}
