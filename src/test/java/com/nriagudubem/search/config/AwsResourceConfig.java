package com.nriagudubem.search.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Slf4j
public class AwsResourceConfig {

    @Value("${sqs.queue.name}")
    private String queueName;

    @Bean
    @Primary
    AmazonSQS getAmazonSqs(@Value("${localstack.host}") final String host,
                           @Value("${localstack.tcp.4576}") final Integer port) {
        AmazonSQSAsync sqsClient = AmazonSQSAsyncClientBuilder.standard().withEndpointConfiguration(
                new AwsClientBuilder.EndpointConfiguration(host + ":" + port, "cn-north-3")
        ).withClientConfiguration(new ClientConfiguration().withProtocol(Protocol.HTTP)).build();
        sqsClient.createQueue(queueName);
//        log.info("createdQueue with name={}", queueName);
        return sqsClient;
    }
}
