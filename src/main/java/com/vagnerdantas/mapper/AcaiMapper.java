package com.vagnerdantas.mapper;

import com.vagnerdantas.enumeration.AdditionalEnum;
import com.vagnerdantas.enumeration.FlavorEnum;
import com.vagnerdantas.persistence.domain.Acai;
import com.vagnerdantas.persistence.domain.AcaiDTO;
import com.vagnerdantas.persistence.domain.AcaiResponseDTO;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright @author Vagner Dantas
 */
public class AcaiMapper {

    private static final long serialVersionUID = 7659073175654466068L;
    private static final int FIVE_MINUTES = 5;
    private static final String SMALL = "Pequeno";
    private static final String MEDIUM = "Médio";
    private static final String BIGGER = "Grande";
    private static final int ZERO = 0;
    private static final int TEN_MINUTES = 10;
    private static final int SEVEN_MINUTES = 7;
    private static final long MINUTES_TO_ADD = 5L;
    private static final long VAL = 13L;
    private static final long MINUTES_TO_ADD1 = 7L;
    private static final long VAL1 = 15L;
    private static final long MINUTES_TO_ADD2 = 10L;

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

    public static Acai setUpAcai(Acai acai) {
        switch (acai.getSize().getValue()) {
            case SMALL:
                acai.setTotal(BigDecimal.TEN);
                if (acai.getFlavor().getValue().equals(FlavorEnum.KIWI.getValue())) {
                    LocalTime currentTime = LocalTime.of(ZERO, FIVE_MINUTES, ZERO);
                    acai.setPreparationTime(currentTime.plusMinutes(MINUTES_TO_ADD));
                } else {
                    acai.setPreparationTime(LocalTime.of(ZERO, FIVE_MINUTES, ZERO));
                }
                break;
            case MEDIUM:
                acai.setTotal(BigDecimal.valueOf(VAL));
                if (acai.getFlavor().getValue().equals(FlavorEnum.KIWI.getValue())) {
                    LocalTime currentTime = LocalTime.of(ZERO, FIVE_MINUTES, ZERO);
                    acai.setPreparationTime(currentTime.plusMinutes(MINUTES_TO_ADD1));
                } else {
                    acai.setPreparationTime(LocalTime.of(ZERO, SEVEN_MINUTES, ZERO));
                }
                break;
            case BIGGER:
                acai.setTotal(BigDecimal.valueOf(VAL1));
                if (acai.getFlavor().getValue().equals(FlavorEnum.KIWI.getValue())) {
                    LocalTime currentTime = LocalTime.of(ZERO, FIVE_MINUTES, ZERO);
                    acai.setPreparationTime(currentTime.plusMinutes(MINUTES_TO_ADD2));
                } else {
                    acai.setPreparationTime(LocalTime.of(ZERO, TEN_MINUTES, ZERO));
                }
                break;
        }
        return acai;
    }

}
