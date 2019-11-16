package com.nriagudubem.search.integrationTest;

import com.nriagudubem.search.helpers.HttpRequestTestHelper;
import com.nriagudubem.search.helpers.MockserverTestHelper;
import com.nriagudubem.search.helpers.SqsTestHelper;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Tag("integration-test")
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseIntegrationTest {
    @LocalServerPort
    private int serverPort;

    @Autowired
    protected MockserverTestHelper mockserverTestHelper;

    @Autowired
    protected SqsTestHelper sqsTestHelper;

    @Autowired
    protected HttpRequestTestHelper httpRequestTestHelper;

    @BeforeAll
    public void setUpPort() {
        RestAssured.port = serverPort;
    }
}
