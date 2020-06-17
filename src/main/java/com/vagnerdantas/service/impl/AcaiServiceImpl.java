package com.vagnerdantas.service.impl;

import com.vagnerdantas.enumeration.AdditionalEnum;
import com.vagnerdantas.enumeration.FlavorEnum;
import com.vagnerdantas.enumeration.HttpStatusEnum;
import com.vagnerdantas.enumeration.MessageEnum;
import com.vagnerdantas.mapper.AcaiMapper;
import com.vagnerdantas.persistence.domain.Acai;
import com.vagnerdantas.persistence.domain.AcaiDTO;
import com.vagnerdantas.persistence.domain.AcaiResponseDTO;
import com.vagnerdantas.persistence.repository.AcaiRepository;
import com.vagnerdantas.service.AcaiService;
import com.vagnerdantas.util.MessageResponseDTO;
import com.vagnerdantas.util.MessageUtil;
import com.vagnerdantas.util.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

/**
 * Copyright @author Vagner Dantas
 */
@Service
public class AcaiServiceImpl implements AcaiService {

    private static final long serialVersionUID = -8636437627144562966L;
    private static final long THREE_MINUTES = 3L;
    private static final int FIVE_MINUTES = 5;
    private static final String SMALL = "Pequeno";
    private static final String MEDIUM = "Médio";
    private static final String BIGGER = "Grande";
    private static final int ZERO = 0;
    private static final int TEN_MINUTES = 10;
    private static final int SEVEN_MINUTES = 7;

    @Autowired
    private AcaiRepository acaiRepository;

    @Override
    public MessageResponseDTO acaiPersist(AcaiDTO acai) {
        acaiRepository.save(this.setUpAcai(AcaiMapper.mapperToAcai(acai)));
        return new MessageResponseDTO(MessageUtil.getStatus(HttpStatusEnum.OK), MessageUtil.getMessage(MessageEnum.MSG001));
    }

    @Override
    public MessageResponseDTO additionalPersist(Integer idAcai, List<AdditionalEnum> additional) {
        Optional<Acai> acai = acaiRepository.findById(idAcai);
        if (acai.isPresent()) {
            for (AdditionalEnum additionalEnum : additional) {
                switch (additionalEnum) {
                    case PACOCA:
                        acai.get().setTotal(acai.get().getTotal().add(BigDecimal.valueOf(THREE_MINUTES)));
                        acai.get().setPreparationTime(acai.get().getPreparationTime().plusMinutes(THREE_MINUTES));
                        break;
                    case LEITE_NINHO:
                        acai.get().setTotal(acai.get().getTotal().add(BigDecimal.valueOf(THREE_MINUTES)));
                        break;
                }
            }
            acai.get().setAdditional(additional);
            acaiRepository.save(acai.get());
        }
        return new MessageResponseDTO(MessageUtil.getStatus(HttpStatusEnum.OK), MessageUtil.getMessage(MessageEnum.MSG005));
    }

    @Override
    public AcaiResponseDTO getAcai(Integer id) {
        Optional<Acai> acai = acaiRepository.findById(id);
        if (acai.isPresent()) {
            return AcaiMapper.mapperToAcaiResponseDTO(acai.get());
        } else {
            throw new NoResultException(HttpStatusEnum.NO_CONTENT.name(), new RuntimeException());
        }
    }

    private Acai setUpAcai(Acai acai) {
        switch (acai.getSize().getValue()) {
            case SMALL:
                acai.setTotal(BigDecimal.TEN);
                if (acai.getFlavor().getValue().equals(FlavorEnum.KIWI.getValue())) {
                    LocalTime currentTime = LocalTime.of(ZERO, FIVE_MINUTES, ZERO);
                    acai.setPreparationTime(currentTime.plusMinutes(5L));
                } else {
                    acai.setPreparationTime(LocalTime.of(ZERO, FIVE_MINUTES, ZERO));
                }
                break;
            case MEDIUM:
                acai.setTotal(BigDecimal.valueOf(13L));
                if (acai.getFlavor().getValue().equals(FlavorEnum.KIWI.getValue())) {
                    LocalTime currentTime = LocalTime.of(ZERO, FIVE_MINUTES, ZERO);
                    acai.setPreparationTime(currentTime.plusMinutes(7L));
                } else {
                    acai.setPreparationTime(LocalTime.of(ZERO, SEVEN_MINUTES, ZERO));
                }
                break;
            case BIGGER:
                acai.setTotal(BigDecimal.valueOf(15L));
                if (acai.getFlavor().getValue().equals(FlavorEnum.KIWI.getValue())) {
                    LocalTime currentTime = LocalTime.of(ZERO, FIVE_MINUTES, ZERO);
                    acai.setPreparationTime(currentTime.plusMinutes(10L));
                } else {
                    acai.setPreparationTime(LocalTime.of(ZERO, TEN_MINUTES, ZERO));
                }
                break;
        }
        return acai;
    }
}
