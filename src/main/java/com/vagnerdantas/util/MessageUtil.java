package com.vagnerdantas.util;

import com.vagnerdantas.enumeration.HttpStatusEnum;
import com.vagnerdantas.enumeration.MessageEnum;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Copyright @author Vagner Dantas
 */
public final class MessageUtil {

    private static final long serialVersionUID = -8588274621770170925L;

    public static final String MESSAGES = "messages";
    public static final String EN = "en";
    public static final String COUNTRY = "US";

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(MESSAGES, new Locale(EN, COUNTRY));

    private MessageUtil() {
        super();
    }

    public static String getStatus(HttpStatusEnum httpStatusEnum) {
        return httpStatusEnum.getCode().toString();

    }

    public static String getMessage(MessageEnum messageEnum) {
        return new String(RESOURCE_BUNDLE.getString(messageEnum.toString()).getBytes());
    }
}
