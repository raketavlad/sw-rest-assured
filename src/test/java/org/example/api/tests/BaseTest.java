package org.example.api.tests;

import io.restassured.RestAssured;
import org.example.api.services.PeopleService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected PeopleService peopleService;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.config = RestAssured.config()
                .httpClient(RestAssured.config()
                        .getHttpClientConfig()
                        .reuseHttpClientInstance());
    }

    @BeforeClass
    public void setUp() {
        peopleService = new PeopleService();
    }
}
