package com.nriagudubem.search.integrationTest;

import com.nriagudubem.search.httpClient.email.dto.GetEmailRequestDto;
import com.nriagudubem.search.httpClient.email.dto.GetEmailResponseDto;
import com.nriagudubem.search.httpClient.email.dto.PropertiesValue;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SearchIntegrationTest extends BaseIntegrationTest {

    @BeforeEach
    private void setup() {
        mockserverTestHelper.reset();
    }

    @Test
    void testWhenSearchIsMade_ThenReturnsCorrectResponse() {
        String query = "senior software engineer";
        httpRequestTestHelper.startSearch("senior software engineer")
                .then().statusCode(HttpStatus.ACCEPTED.value());

        mockserverTestHelper.requestIsMadeToSearch(buildRequestDto(query), buildResponseDto());
        //await the message is read and verify there is no more message in the queue
    }

    private GetEmailRequestDto buildRequestDto(String query) {
        return GetEmailRequestDto.builder()
                .safeSearch(true)
                .autoCorrect(false)
                .pageNumber(1L)
                .pageSize(20L)
                .query(query)
                .build();
    }

    private GetEmailResponseDto buildResponseDto() {
        List<PropertiesValue> values = new ArrayList<>();
        try {
            URL url = new URL("http://seniorEngineer.com");
            values.add(PropertiesValue.builder().url(url).title("my title").build());
            return GetEmailResponseDto.builder()
                    .value(values)
                    .build();
        } catch (MalformedURLException ex) {
//            log.error("error={}", ex.getMessage());
        }

        return null;
    }
}
