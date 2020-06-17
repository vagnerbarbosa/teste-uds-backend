package com.vagnerdantas.service.impl;

import com.vagnerdantas.enumeration.AdditionalEnum;
import com.vagnerdantas.enumeration.FlavorEnum;
import com.vagnerdantas.enumeration.HttpStatusEnum;
import com.vagnerdantas.enumeration.MessageEnum;
import com.vagnerdantas.mapper.AcaiMapper;
import com.vagnerdantas.persistence.domain.Acai;
import com.vagnerdantas.persistence.domain.AcaiDTO;
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

    @Autowired
    private AcaiRepository acaiRepository;

    @Override
    public MessageResponseDTO acaiPersist(AcaiDTO acai) {
        acaiRepository.save(this.setUpAcai(AcaiMapper.mapperToAcai(acai)));
        return new MessageResponseDTO(MessageUtil.getStatus(HttpStatusEnum.OK), MessageUtil.getMessage(MessageEnum.MSG001));
    }

    @Override
    public MessageResponseDTO additionalPersist(Integer idAcai, List<AdditionalEnum> additional) {
        Acai acai = this.getAcai(idAcai);
        for (AdditionalEnum additionalEnum : additional) {
            switch (additionalEnum) {
                case PACOCA:
                    acai.setTotal(acai.getTotal().add(BigDecimal.valueOf(3L)));
                    acai.setPreparationTime(acai.getPreparationTime().plusMinutes(3L));
                    break;
                case LEITE_NINHO:
                    acai.setTotal(acai.getTotal().add(BigDecimal.valueOf(3L)));
                    break;
            }
        }
        acai.setAdditional(additional);
        acaiRepository.save(acai);
        return new MessageResponseDTO(MessageUtil.getStatus(HttpStatusEnum.OK), MessageUtil.getMessage(MessageEnum.MSG001));
    }

    @Override
    public Acai getAcai(Integer id) {
        Optional<Acai> acai = acaiRepository.findById(id);
        if (acai.isPresent()) {
            return acai.get();
        } else {
            throw new NoResultException(HttpStatusEnum.NO_CONTENT.name(), new RuntimeException());
        }
    }

    private Acai setUpAcai(Acai acai) {
        switch (acai.getSize().getValue()) {
            case "Pequeno":
                acai.setTotal(BigDecimal.TEN);
                if (acai.getFlavor().getValue().equals(FlavorEnum.KIWI.getValue())) {
                    LocalTime currentTime = LocalTime.of(0,5,0);
                    acai.setPreparationTime(currentTime.plusMinutes(5L));
                } else {
                    acai.setPreparationTime(LocalTime.of(0, 5, 0));
                }
                break;
            case "Médio":
                acai.setTotal(BigDecimal.valueOf(13L));
                if (acai.getFlavor().getValue().equals(FlavorEnum.KIWI.getValue())) {
                    LocalTime currentTime = LocalTime.of(0,5,0);
                    acai.setPreparationTime(currentTime.plusMinutes(7L));
                } else {
                    acai.setPreparationTime(LocalTime.of(0, 7, 0));
                }
                break;
            case "Grande":
                acai.setTotal(BigDecimal.valueOf(15L));
                if (acai.getFlavor().getValue().equals(FlavorEnum.KIWI.getValue())) {
                    LocalTime currentTime = LocalTime.of(0,5,0);
                    acai.setPreparationTime(currentTime.plusMinutes(10L));
                } else {
                    acai.setPreparationTime(LocalTime.of(0, 10, 0));
                }
                break;
        }
        return acai;
    }
}
