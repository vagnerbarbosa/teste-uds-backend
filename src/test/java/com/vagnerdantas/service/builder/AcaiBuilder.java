package com.vagnerdantas.service.builder;

import com.vagnerdantas.enumeration.FlavorEnum;
import com.vagnerdantas.enumeration.SizeEnum;
import com.vagnerdantas.persistence.domain.Acai;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright @author Vagner Dantas
 */
public class AcaiBuilder {

    private Acai acai;

    public AcaiBuilder() {
        super();
    }

    public static AcaiBuilder getInstance() {
        AcaiBuilder acaiBuilder = new AcaiBuilder();
        acaiBuilder.acai = new Acai();
        acaiBuilder.acai.setId(0);
        acaiBuilder.acai.setTotal(BigDecimal.TEN);
        acaiBuilder.acai.setSize(SizeEnum.GRANDE);
        acaiBuilder.acai.setFlavor(FlavorEnum.KIWI);
        acaiBuilder.acai.setPreparationTime(LocalTime.now());
        return acaiBuilder;
    }

    public Acai getAcai() {
        return acai;
    }

    private List<Acai> listGenerate(int qtd) {
        List<Acai> lista = new ArrayList<Acai>();
        for (int i = 0; i < qtd; i++) {
            lista.add(AcaiBuilder.getInstance().getAcai());
        }
        return lista;
    }

    public List<Acai> getList(int lenght) {
        return this.listGenerate(lenght);
    }
}
