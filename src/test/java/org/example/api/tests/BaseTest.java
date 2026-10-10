package org.example.api.tests;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import org.example.api.config.ConfigProvider;
import org.example.api.services.FilmsService;
import org.example.api.services.PeopleService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected PeopleService peopleService;
    protected FilmsService filmsService;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.config = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout", ConfigProvider.TIMEOUT)
                        .setParam("http.socket.timeout", ConfigProvider.TIMEOUT));
    }

    @BeforeClass
    public void setUp() {
        peopleService = new PeopleService();
        filmsService = new FilmsService();
    }
}
