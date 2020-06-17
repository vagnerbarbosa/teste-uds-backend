package com.vagnerdantas.service.impl;

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
    public Acai getAcai(Integer id) {
        Optional<Acai> acai = acaiRepository.findById(id);
        if (acai.isPresent()) {
            return acai.get();
        } else {
            throw new NoResultException(HttpStatusEnum.NO_CONTENT.name(), new RuntimeException());
        }
    }

    private Acai setUpAcai(Acai acai) {
        if (acai.getFlavor().getValue().equals(FlavorEnum.KIWI.getValue())) {
            LocalTime currentTime = LocalTime.of(0,5,0);
            acai.setPreparationTime(currentTime);
        }
        switch (acai.getSize().getValue()) {
            case "Pequeno":
                acai.setTotal(BigDecimal.TEN);
                acai.setPreparationTime(acai.getPreparationTime().plusMinutes(5L));
                break;
            case "Médio":
                acai.setTotal(BigDecimal.valueOf(13L));
                acai.setPreparationTime(acai.getPreparationTime().plusMinutes(7L));
                break;
            case "Grande":
                acai.setTotal(BigDecimal.valueOf(15L));
                acai.setPreparationTime(acai.getPreparationTime().plusMinutes(10L));
                break;
        }
        return acai;
    }
}
