package com.nriagudubem.search.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nriagudubem.search.sqs.dto.SearchMessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SearchMessagePublisher {
    @Value("${sqs.queue.name}")
    private String queueName;

    private final ObjectMapper objectMapper;

    private final AmazonSQS amazonSQS;

    public void publishMessage(SearchMessageDto searchMessageDto) {
        try {
            SendMessageRequest sendMsgRequest = new SendMessageRequest()
                    .withQueueUrl(amazonSQS.getQueueUrl(queueName).getQueueUrl())
                    .withMessageGroupId(searchMessageDto.getUser().getEmail())
                    .withMessageBody(objectMapper.writeValueAsString(searchMessageDto));

            amazonSQS.sendMessage(sendMsgRequest);
            log.info("message has been published successfully message={}", searchMessageDto.toString());
        } catch (Exception ex) {
            log.error("There was an error publishing message to queue. exception={}", ex.getMessage());
        }
    }

}
