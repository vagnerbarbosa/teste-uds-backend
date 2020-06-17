package com.vagnerdantas.controller;

import com.vagnerdantas.enumeration.AdditionalEnum;
import com.vagnerdantas.persistence.domain.AcaiDTO;
import com.vagnerdantas.persistence.domain.AcaiResponseDTO;
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
    public static final String ACAIS = "/acais";
    public static final String APPLICATION_JSON = "application/json";
    public static final String ACAI_ID = "/acais/{id}";

    @Autowired
    private AcaiService acaiService;

    @RequestMapping(value = ACAIS, method = RequestMethod.POST, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public MessageResponseDTO acaiPersist(@RequestBody AcaiDTO acai) {
        return acaiService.acaiPersist(acai);
    }

    @RequestMapping(value = "/acais/{id}", method = RequestMethod.POST, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public MessageResponseDTO additionalPersist(@PathVariable(value = "id") Integer id, @RequestBody List<AdditionalEnum> list) {
        return acaiService.additionalPersist(id, list);
    }

    @GetMapping(ACAI_ID)
    public AcaiResponseDTO getAcai(@PathVariable(ID) Integer id) {
        return acaiService.getAcai(id);
    }
}
