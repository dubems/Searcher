package com.nriagudubem.search.services;

import com.nriagudubem.search.commons.SearchEngine;
import com.nriagudubem.search.httpClient.email.EmailHttpClient;
import com.nriagudubem.search.httpClient.email.dto.GetEmailRequestDto;
import com.nriagudubem.search.httpClient.email.dto.GetEmailResponseDto;
import com.nriagudubem.search.sqs.dto.SearchMessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContextualWebSearch implements SearchEngine {

    private final CrawlerService crawlerService;
    private final EmailHttpClient emailHttpClient;

    @Value("${search.contextualWeb.apiKey}")
    private String apiKey;

    @Override
    public GetEmailResponseDto getEmails(SearchMessageDto searchMessageDto) {
        log.info("message have been consumed from queue. message={}", searchMessageDto);
        GetEmailRequestDto emailRequestDto = buildEmailRequest(searchMessageDto);

        log.info("apiKey={}", apiKey);
        GetEmailResponseDto responseDto = emailHttpClient.getEmails(emailRequestDto.getAutoCorrect(),
                emailRequestDto.getPageSize(), emailRequestDto.getSafeSearch(), emailRequestDto.getPageNumber(),
                emailRequestDto.getQuery());

        responseDto.getValue().stream().peek(propertiesValue -> log.info("urls={}", propertiesValue.getUrl())).collect(Collectors.toList());

        return responseDto;
//        crawlerService.crawl(emailHttpClient.getEmails(emailRequestDto.getAutoCorrect(),
//                emailRequestDto.getPageSize(), emailRequestDto.getSafeSearch(), emailRequestDto.getPageNumber(),
//                emailRequestDto.getQuery(), apiKey)
//        );
    }

    private GetEmailRequestDto buildEmailRequest(SearchMessageDto searchMessageDto) {
        return GetEmailRequestDto.builder()
                .autoCorrect(true)
                .pageNumber(1L)
                .pageSize(10L)
                .safeSearch(false)
                .query(searchMessageDto.getSearchQuery())
                .build();
    }
}
