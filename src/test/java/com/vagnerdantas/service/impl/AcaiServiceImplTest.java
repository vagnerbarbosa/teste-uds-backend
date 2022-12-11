package com.vagnerdantas.service.impl;

import com.vagnerdantas.enumeration.AdditionalEnum;
import com.vagnerdantas.enumeration.FlavorEnum;
import com.vagnerdantas.enumeration.SizeEnum;
import com.vagnerdantas.persistence.domain.Acai;
import com.vagnerdantas.persistence.domain.AcaiDTO;
import com.vagnerdantas.persistence.repository.AcaiRepository;
import com.vagnerdantas.service.builder.AcaiBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Vagner Dantas <contato@vagnerbarbosa.com>
 * @since 26 de mar de 2020
 */
@RunWith(MockitoJUnitRunner.class)
public class AcaiServiceImplTest {

    @Mock
    private AcaiRepository acaiRepository;

    @InjectMocks
    private AcaiServiceImpl acaiService;

    @Test
    public void acaiPersist() {
        Acai acai = AcaiBuilder.getInstance().getAcai();
        AcaiDTO dto = new AcaiDTO();
        dto.setFlavor(FlavorEnum.KIWI);
        dto.setSize(SizeEnum.GRANDE);
        Mockito.when(acaiRepository.save(acai)).thenReturn(acai);
        Assert.assertNotNull(acaiService.acaiPersist(dto));
    }

    @Test
    public void additionalPersistLeiteNinho() {
        Acai acai = AcaiBuilder.getInstance().getAcai();
        AcaiDTO dto = new AcaiDTO();
        dto.setFlavor(FlavorEnum.KIWI);
        dto.setSize(SizeEnum.GRANDE);
        List<AdditionalEnum> additional = new ArrayList<>();
        additional.add(AdditionalEnum.LEITE_NINHO);
        acai.setAdditional(additional);
        Mockito.when(acaiRepository.findById(acai.getId())).thenReturn(Optional.of(acai));
        Mockito.when(acaiRepository.save(acai)).thenReturn(acai);
        Assert.assertNotNull(acaiService.additionalPersist(acai.getId(), additional));
    }

    @Test
    public void additionalPersistPacoca() {
        Acai acai = AcaiBuilder.getInstance().getAcai();
        AcaiDTO dto = new AcaiDTO();
        dto.setFlavor(FlavorEnum.KIWI);
        dto.setSize(SizeEnum.GRANDE);
        List<AdditionalEnum> additional = new ArrayList<>();
        additional.add(AdditionalEnum.PACOCA);
        acai.setAdditional(additional);
        Mockito.when(acaiRepository.findById(acai.getId())).thenReturn(Optional.of(acai));
        Mockito.when(acaiRepository.save(acai)).thenReturn(acai);
        Assert.assertNotNull(acaiService.additionalPersist(acai.getId(), additional));
    }

    @Test
    public void additionalPersistGranola() {
        Acai acai = AcaiBuilder.getInstance().getAcai();
        AcaiDTO dto = new AcaiDTO();
        dto.setFlavor(FlavorEnum.KIWI);
        dto.setSize(SizeEnum.GRANDE);
        List<AdditionalEnum> additional = new ArrayList<>();
        additional.add(AdditionalEnum.GRANOLA);
        acai.setAdditional(additional);
        Mockito.when(acaiRepository.findById(acai.getId())).thenReturn(Optional.of(acai));
        Mockito.when(acaiRepository.save(acai)).thenReturn(acai);
        Assert.assertNotNull(acaiService.additionalPersist(acai.getId(), additional));
    }

    @Test
    public void getAcai() {
        Acai acai = AcaiBuilder.getInstance().getAcai();
        AcaiDTO dto = new AcaiDTO();
        dto.setFlavor(FlavorEnum.KIWI);
        dto.setSize(SizeEnum.GRANDE);
        List<AdditionalEnum> additional = new ArrayList<>();
        additional.add(AdditionalEnum.GRANOLA);
        acai.setAdditional(additional);
        Mockito.when(acaiRepository.findById(acai.getId())).thenReturn(Optional.of(acai));
        Assert.assertNotNull(acaiService.getAcai(acai.getId()));
    }
}
