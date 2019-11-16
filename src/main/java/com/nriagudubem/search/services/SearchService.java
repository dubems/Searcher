package com.nriagudubem.search.services;

import com.nriagudubem.search.sqs.SearchMessagePublisher;
import com.nriagudubem.search.sqs.dto.SearchMessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchService {
    private final SearchMessagePublisher searchMessagePublisher;

    public void publishMessageToQueue(SearchMessageDto searchMessageDto) {
        searchMessagePublisher.publishMessage(searchMessageDto);
    }
}
