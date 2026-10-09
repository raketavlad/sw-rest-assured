package org.example.api.services;

import io.restassured.response.Response;
import org.example.api.endpoints.Endpoints;
import org.example.api.specifications.RequestSpec;
import org.example.api.specifications.ResponseSpec;

import static io.restassured.RestAssured.given;

public class PeopleService {

    public Response getAllPerson() {
        return given()
                .spec(RequestSpec.getCommonRequestSpec()) // <--- Применяем спецификацию!
                .when()
                .get(Endpoints.PEOPLE)
                .then()
                .spec(ResponseSpec.getSuccessResponseSpec()) // <--- Проверяем статус 200 и логируем ответ
                .extract()
                .response();
    }

    public Response getPerson(int id) {
        return given()
                .spec(RequestSpec.getCommonRequestSpec()) // <--- Применяем спецификацию!
                .pathParam("id", id)
                .when()
                .get(Endpoints.PERSON_BY_ID)
                .then()
                .spec(ResponseSpec.getSuccessResponseSpec()) // <--- Проверяем статус 200 и логируем ответ
                .extract()
                .response();
    }
}
