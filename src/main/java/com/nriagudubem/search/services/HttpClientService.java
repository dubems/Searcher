package com.nriagudubem.search.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class HttpClientService {

    private RestTemplate restTemplate;

    public HttpClientService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

//    public <T> ResponseEntity<T> getEntity(String url, Map<String, ?> queryParams, Class<T> clazz, Map<String, String> headers) {
//        HttpStatus statusCode = HttpStatus.OK;
//        try {
//            String formattedUrl = queryParams.isEmpty() ? url : appendQueryParams(url, queryParams);
//            HttpHeaders httpHeaders = new HttpHeaders();
//            headers.entrySet().forEach(entry -> httpHeaders.set(entry.getKey(), entry.getValue()));
//            HttpEntity httpEntity = new HttpEntity(httpHeaders);
//            ResponseEntity<T> response = restTemplate.exchange(formattedUrl, HttpMethod.GET, httpEntity, clazz);
//            statusCode = response.getStatusCode();
//            if (statusCode == HttpStatus.OK) {
//                log.info("successful request to get emails");
//                return response;
//            }
//
//            throw new Exception("Get request was not successful");
//
//        } catch (RestClientException ex) {
//            log.error("There was an error making get request " + ex.getMessage());
//        } catch (Exception ex) {
//            log.error("Get request returned status code of " + statusCode);
//        }
//
//        return null;
//    }
//
//    private String appendQueryParams(String url, Map<String, ?> params) {
//        String uriParam = params.entrySet().stream()
//                .map(entry -> entry.getKey() + "=" + entry.getValue())
//                .collect(Collectors.joining("&"));
//        return url + "?" + uriParam;
//    }
}
