package org.example.api.services;

import org.example.api.endpoints.Endpoints;
import org.example.api.models.response.SpeciesResponse;
import org.example.api.specifications.RequestSpec;
import org.example.api.specifications.ResponseSpec;

import java.util.List;

import static io.restassured.RestAssured.given;

public class SpeciesService {

    public List<SpeciesResponse> getAllSpecies() {
        return given()
                .spec(RequestSpec.getCommonRequestSpec()) // <--- Применяем спецификацию!
                .when()
                .get(Endpoints.SPECIES)
                .then()
                .spec(ResponseSpec.getSuccessResponseSpec()) // <--- Проверяем статус 200 и логируем ответ
                .extract().jsonPath().getList("", SpeciesResponse.class);
    }

    public SpeciesResponse getSpecies(int id) {
        return given()
                .spec(RequestSpec.getCommonRequestSpec()) // <--- Применяем спецификацию!
                .pathParam("id", id)
                .when()
                .get(Endpoints.SPECIES_BY_ID)
                .then()
                .spec(ResponseSpec.getSuccessResponseSpec()) // <--- Проверяем статус 200 и логируем ответ
                .extract().as(SpeciesResponse.class);
    }
}
