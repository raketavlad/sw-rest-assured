package org.example.api.specifications;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
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
//                .log(LogDetail.ALL) // Выводит весь лог запроса (нужно для дебага)
                // Главная интеграция с Allure: фильтр перехватывает запрос
                // и прикрепляет его красивым вложением (Attachment) в отчет
                .addFilter(new AllureRestAssured())
                .build();
    }
}
