package com.vagnerdantas.service.impl;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.PathNotFoundException;
import com.toomuchcoding.jsonassert.JsonPath;
import com.vagnerdantas.enumeration.HttpStatusEnum;
import com.vagnerdantas.enumeration.MessageEnum;
import com.vagnerdantas.mapper.AcaiMapper;
import com.vagnerdantas.persistence.domain.Acai;
import com.vagnerdantas.persistence.domain.AcaiDTO;
import com.vagnerdantas.persistence.repository.AcaiRepository;
import com.vagnerdantas.service.AcaiService;
import com.vagnerdantas.util.NoResultException;
import com.vagnerdantas.util.JsonParserUtil;
import com.vagnerdantas.util.MessageResponseDTO;
import com.vagnerdantas.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright @author Vagner Dantas
 */
@Service
public class AcaiServiceImpl implements AcaiService {

    private static final long serialVersionUID = -8636437627144562966L;

    public static final String REPOSITORY = "repository";
    public static final String EVENTS_URL = "events_url";
    public static final String TYPE = "type";
    public static final String ISSUES_EVENT = "IssuesEvent";
    public static final String PAYLOAD = "payload";
    public static final String ACTION = "action";
    public static final String CREATED_AT = "created_at";
    public static final String ISSUE = "issue";
    public static final String NUMBER = "number";

    @Autowired
    private AcaiRepository acaiRepository;

    @Override
    public MessageResponseDTO acaiPersist(String message) {
        try {
            if (!message.isEmpty()) {
                DocumentContext parsedJson = com.jayway.jsonpath.JsonPath.parse(message);

                String completeWebhook = parsedJson.read(JsonPath.builder().field(REPOSITORY).field(EVENTS_URL).jsonPath());

                DocumentContext importantJson = com.jayway.jsonpath.JsonPath.parse(JsonParserUtil.jsonGetRequest(completeWebhook));
                int y = 0;
                List<Acai> events = new ArrayList<>();
                for (int i = 0; i <= y; i++) {
                    Acai event = new Acai();
                    if (importantJson.read(JsonPath.builder().elementWithIndex(i).field(TYPE).jsonPath()).equals(ISSUES_EVENT)) {
                        String action = importantJson
                                .read(JsonPath.builder().elementWithIndex(i).field(PAYLOAD).field(ACTION).jsonPath());

                        String createAt = importantJson
                                .read(JsonPath.builder().elementWithIndex(i).field(CREATED_AT).jsonPath());

                        Integer numberIssue = importantJson
                                .read(JsonPath.builder().elementWithIndex(i).field(PAYLOAD).field(ISSUE).field(NUMBER).jsonPath());

                        events.add(event);
                        y++;
                    }
                }
                acaiRepository.saveAll(events);
                return new MessageResponseDTO(MessageUtil.getStatus(HttpStatusEnum.OK), MessageUtil.getMessage(MessageEnum.MSG001));
            }
        } catch (PathNotFoundException e) {
            throw new NoResultException(MessageUtil.getMessage(MessageEnum.MSG002), new RuntimeException());
        }
        return new MessageResponseDTO(MessageUtil.getStatus(HttpStatusEnum.NO_CONTENT), MessageUtil.getMessage(MessageEnum.MSG002));
    }

    @Override
    public List<AcaiDTO> getAll(String id) {
        List<AcaiDTO> events = AcaiMapper.mapperAllToDTO(acaiRepository.findAllById(id));
        if (events.isEmpty()) {
            throw new NoResultException(MessageUtil.getMessage(MessageEnum.MSG003), new RuntimeException());
        } else {
            return events;
        }
    }
}
