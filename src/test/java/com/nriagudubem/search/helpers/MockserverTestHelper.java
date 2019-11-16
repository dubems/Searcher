package com.nriagudubem.search.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nriagudubem.search.httpClient.email.dto.GetEmailRequestDto;
import com.nriagudubem.search.httpClient.email.dto.GetEmailResponseDto;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.mockserver.client.MockServerClient;
import org.mockserver.matchers.Times;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.model.HttpStatusCode;
import org.mockserver.model.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MockserverTestHelper {

    @Autowired
    private MockServerClient mockServerClient;

    @Autowired
    private ObjectMapper objectMapper;

    private final static String GET_EMAILS = "/api/Search/WebSearchAPI";

    public void requestIsMadeToSearch(GetEmailRequestDto emailRequestDto, GetEmailResponseDto responseDto) {
        List<Parameter> params = new ArrayList<>();
        mockServerClient.when(HttpRequest.request(GET_EMAILS).withQueryStringParameters(params), Times.once())
                .respond(HttpResponse.response(toJson(responseDto)).withStatusCode(HttpStatusCode.OK_200.code()));
    }

    public void reset() {
        mockServerClient.reset();
    }

    private String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("failed to serialize object", e);
        }
    }

}
