package com.nriagudubem.search.config;

import org.mockserver.client.MockServerClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockServerConfig {

    @Bean
    public MockServerClient mockServerClient(@Value("${mockServer.host}") String host,
                                             @Value("${mockServer.tcp.1080}") Integer port) {
        System.out.println(port);
        return new MockServerClient(host, port);
    }
}
