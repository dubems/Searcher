package com.nriagudubem.search.helpers;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Component
public class HttpRequestTestHelper {

    private final static String SEARCH_ENDPOINT = "/search";

    public Response startSearch(String searchQuery) {
        return given().contentType(ContentType.JSON).accept(ContentType.JSON).when().get(SEARCH_ENDPOINT+"?query="+searchQuery);
    }
}
