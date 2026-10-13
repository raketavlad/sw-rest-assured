package org.example.api.specifications;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.example.api.config.ConfigProvider;

public class RequestSpec {
    /**
     * Общая спецификация для ВСЕХ входящих запросов к API.
     * Настраивает базовый URL, тип контента и автоматическое логирование в консоль и Allure.
     */
    public static RequestSpecification getCommonRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigProvider.BASE_URL)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setConfig(RestAssuredConfig.config()
                        .httpClient((HttpClientConfig.httpClientConfig()
                                .setParam("http.connection.timeout", ConfigProvider.TIMEOUT)
                                .setParam("http.socket.timeout", ConfigProvider.TIMEOUT))))
//                .log(LogDetail.ALL) // Выводит весь лог запроса (нужно для дебага)
                .addFilter(new AllureRestAssured())
                .build();
    }
}
