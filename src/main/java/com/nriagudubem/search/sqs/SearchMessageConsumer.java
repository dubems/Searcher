package com.nriagudubem.search.sqs;

import com.nriagudubem.search.commons.SearchEngine;
import com.nriagudubem.search.sqs.dto.SearchMessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SearchMessageConsumer {
    private final SearchEngine searchEngine;

    @MessageMapping(value = "${sqs.queue.name}")
    @SqsListener(value = "${sqs.queue.name}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void consumeSearchMessage(SearchMessageDto searchMessageDto) {
        searchEngine.getEmails(searchMessageDto);
    }

    @MessageExceptionHandler(Exception.class)
    public void handleExceptions(Exception ex) {
        log.error("Exception occurred while consuming messages" + ex.getMessage());
    }
}
