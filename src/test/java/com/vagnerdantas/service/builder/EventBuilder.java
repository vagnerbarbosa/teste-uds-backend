package com.vagnerdantas.service.builder;

import com.vagnerdantas.persistence.domain.Acai;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright @author Vagner Dantas
 */
public class EventBuilder {

    private Acai event;

    public EventBuilder() {
        super();
    }

    public static EventBuilder getInstance() {
        EventBuilder eventBuilder = new EventBuilder();
        eventBuilder.event = new Acai();
        eventBuilder.event.setId(0);
        return eventBuilder;
    }

    public Acai getEvent() {
        return event;
    }

    private List<Acai> listGenerate(int qtd) {
        List<Acai> lista = new ArrayList<Acai>();
        for (int i = 0; i < qtd; i++) {
            lista.add(EventBuilder.getInstance().getEvent());
        }
        return lista;
    }

    public List<Acai> getList(int lenght) {
        return this.listGenerate(lenght);
    }
}
