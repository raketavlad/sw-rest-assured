package org.example.api.specifications;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec {
    /**
     * Переиспользуемая спецификация для проверки успешных ответов (например, статус 200).
     * Полезно для базовых проверок, чтобы не писать .statusCode(200) в каждом тесте.
     */
    public static ResponseSpecification getSuccessResponseSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
//                .log(LogDetail.ALL) // Выводит весь лог ответа (нужно для дебага)
                .build();
    }
}
