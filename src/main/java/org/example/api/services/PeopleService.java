package org.example.api.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.api.specifications.RequestSpec;
import org.example.api.specifications.ResponseSpec;

public class PeopleService {

    public Response getAllPerson() {
        return RestAssured.given()
                .spec(RequestSpec.getCommonRequestSpec()) // <--- Применяем спецификацию!
                .when()
                .get("/people")
                .then()
                .spec(ResponseSpec.getSuccessResponseSpec()) // <--- Проверяем статус 200 и логируем ответ
                .extract()
                .response();
    }

    public Response getPerson(int id) {
        return RestAssured.given()
                .spec(RequestSpec.getCommonRequestSpec()) // <--- Применяем спецификацию!
                .when()
                .get("/people/" + id)
                .then()
                .spec(ResponseSpec.getSuccessResponseSpec()) // <--- Проверяем статус 200 и логируем ответ
                .extract()
                .response();
    }
}
