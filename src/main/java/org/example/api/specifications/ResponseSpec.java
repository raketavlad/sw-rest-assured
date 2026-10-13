package org.example.api.specifications;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec {

    public static ResponseSpecification getSuccessResponseSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
//                .log(LogDetail.ALL) // Выводит весь лог ответа (нужно для дебага)
                .build();
    }

    public static ResponseSpecification getNotFoundResponseSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(404)
//                .log(LogDetail.ALL) // Выводит весь лог ответа (нужно для дебага)
                .build();
    }
}
