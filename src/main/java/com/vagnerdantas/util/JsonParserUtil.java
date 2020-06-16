package com.vagnerdantas.util;

import com.vagnerdantas.enumeration.MessageEnum;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Copyright @author Vagner Dantas
 */
public class JsonParserUtil {

    private static final long serialVersionUID = -5042672081502816444L;
    public static final String UTF_8 = "UTF-8";
    public static final String PATTERN = "\\Z";
    public static final String REQUEST_METHOD = "GET";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String APPLICATION_JSON = "application/json";
    public static final String CHARSET = "charset";

    public JsonParserUtil() { super(); }

    private static String streamToString(InputStream inputStream) {
        String text = new Scanner(inputStream, UTF_8).useDelimiter(PATTERN).next();
        return text;
    }

    public static String jsonGetRequest(String urlQueryString) {
        String json;
        try {
            URL url = new URL(urlQueryString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod(REQUEST_METHOD);
            connection.setRequestProperty(CONTENT_TYPE, APPLICATION_JSON);
            connection.setRequestProperty(CHARSET, UTF_8);
            connection.connect();
            InputStream inStream = connection.getInputStream();
            json = streamToString(inStream);
        } catch (IOException ex) {
            throw new NoResultException(MessageUtil.getMessage(MessageEnum.MSG004), new RuntimeException());
        }
        return json;
    }
}
