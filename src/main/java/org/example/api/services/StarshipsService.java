package org.example.api.services;

import org.example.api.endpoints.Endpoints;
import org.example.api.models.response.StarshipsResponse;
import org.example.api.specifications.RequestSpec;
import org.example.api.specifications.ResponseSpec;

import java.util.List;

import static io.restassured.RestAssured.given;

public class StarshipsService {

    public List<StarshipsResponse> getAllStarships() {
        return given()
                .spec(RequestSpec.getCommonRequestSpec()) // <--- Применяем спецификацию!
                .when()
                .get(Endpoints.STARSHIPS)
                .then()
                .spec(ResponseSpec.getSuccessResponseSpec()) // <--- Проверяем статус 200 и логируем ответ
                .extract().jsonPath().getList("", StarshipsResponse.class);
    }

    public StarshipsResponse getStarship(int id) {
        return given()
                .spec(RequestSpec.getCommonRequestSpec()) // <--- Применяем спецификацию!
                .pathParam("id", id)
                .when()
                .get(Endpoints.STARSHIP_BY_ID)
                .then()
                .spec(ResponseSpec.getSuccessResponseSpec()) // <--- Проверяем статус 200 и логируем ответ
                .extract().as(StarshipsResponse.class);
    }
}
