package com.vagnerdantas.controller;

import com.vagnerdantas.persistence.domain.AcaiDTO;
import com.vagnerdantas.service.AcaiService;
import com.vagnerdantas.util.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Copyright @author Vagner Dantas
 */
@RestController
public class AcaiController {

    private static final long serialVersionUID = -7310028050274068062L;

    public static final String ID = "id";
    public static final String EVENTS = "/events";
    public static final String APPLICATION_JSON = "application/json";
    public static final String ISSUES_ID_EVENTS = "/issues/{id}/events";

    @Autowired
    private AcaiService acaiService;

    @RequestMapping(value = EVENTS, method = RequestMethod.POST, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public MessageResponseDTO acaiPersist(@RequestBody String message) {
        return acaiService.acaiPersist(message);
    }

    @GetMapping(ISSUES_ID_EVENTS)
    public List<AcaiDTO> getAll(@PathVariable(ID) String id) {
        return acaiService.getAll(id);
    }
}
