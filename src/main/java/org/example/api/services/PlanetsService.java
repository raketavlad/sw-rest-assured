package org.example.api.services;

import org.example.api.endpoints.Endpoints;
import org.example.api.models.response.PlanetsResponse;
import org.example.api.specifications.RequestSpec;
import org.example.api.specifications.ResponseSpec;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PlanetsService {

    public List<PlanetsResponse> getAllPlanets() {
        return given()
                .spec(RequestSpec.getCommonRequestSpec()) // <--- Применяем спецификацию!
                .when()
                .get(Endpoints.PLANETS)
                .then()
                .spec(ResponseSpec.getSuccessResponseSpec()) // <--- Проверяем статус 200 и логируем ответ
                .extract().jsonPath().getList("", PlanetsResponse.class);
    }

    public PlanetsResponse getPlanet(int id) {
        return given()
                .spec(RequestSpec.getCommonRequestSpec()) // <--- Применяем спецификацию!
                .pathParam("id", id)
                .when()
                .get(Endpoints.PLANET_BY_ID)
                .then()
                .spec(ResponseSpec.getSuccessResponseSpec()) // <--- Проверяем статус 200 и логируем ответ
                .extract().as(PlanetsResponse.class);
    }
}
