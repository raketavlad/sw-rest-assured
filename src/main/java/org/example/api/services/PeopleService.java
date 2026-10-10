package org.example.api.services;

import org.example.api.endpoints.Endpoints;
import org.example.api.models.response.PeopleResponse;
import org.example.api.specifications.RequestSpec;
import org.example.api.specifications.ResponseSpec;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PeopleService {

    public List<PeopleResponse> getAllPerson() {
        return given()
                .spec(RequestSpec.getCommonRequestSpec()) // <--- Применяем спецификацию!
                .when()
                .get(Endpoints.PEOPLE)
                .then()
                .spec(ResponseSpec.getSuccessResponseSpec()) // <--- Проверяем статус 200 и логируем ответ
                .extract().jsonPath().getList("", PeopleResponse.class);
    }

    public PeopleResponse getPerson(int id) {
        return given()
                .spec(RequestSpec.getCommonRequestSpec()) // <--- Применяем спецификацию!
                .pathParam("id", id)
                .when()
                .get(Endpoints.PERSON_BY_ID)
                .then()
                .spec(ResponseSpec.getSuccessResponseSpec()) // <--- Проверяем статус 200 и логируем ответ
                .extract().as(PeopleResponse.class);
    }
}
