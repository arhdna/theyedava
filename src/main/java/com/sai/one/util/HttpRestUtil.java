package com.sai.one.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Component
public class HttpRestUtil<T> {

    // throws rest client exception please handle in the caller method
    public ResponseEntity<T> HttpGet(Map<String, String> header, Map<String, String> queryParam, String url, Class<T> type) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        if (header != null) {
            for (Map.Entry<String, String> entry : header.entrySet())
                headers.set(entry.getKey(), entry.getValue());
        }

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

        if (queryParam != null) {
            for (Map.Entry<String, String> entry : queryParam.entrySet())
                builder.queryParam(entry.getKey(), entry.getValue());
        }

        HttpEntity<?> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, type);
    }

    public ResponseEntity<T> HttpPut(Map<String, String> header, Map<String, String> queryParam, String url, Class<T> type, String body) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        if (header != null) {
            for (Map.Entry<String, String> entry : header.entrySet())
                headers.set(entry.getKey(), entry.getValue());
        }

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

        if (queryParam != null) {
            for (Map.Entry<String, String> entry : queryParam.entrySet())
                builder.queryParam(entry.getKey(), entry.getValue());
        }

        HttpEntity<?> entity = new HttpEntity<>(body, headers);
        return restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.PUT, entity,
                type);
    }

}