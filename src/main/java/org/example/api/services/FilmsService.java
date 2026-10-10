package org.example.api.services;

import org.example.api.endpoints.Endpoints;
import org.example.api.models.response.FilmsResponse;
import org.example.api.specifications.RequestSpec;
import org.example.api.specifications.ResponseSpec;

import java.util.List;

import static io.restassured.RestAssured.given;

public class FilmsService {

    public List<FilmsResponse> getAllFilms() {
        return given()
                .spec(RequestSpec.getCommonRequestSpec()) // <--- Применяем спецификацию!
                .when()
                .get(Endpoints.FILMS)
                .then()
                .spec(ResponseSpec.getSuccessResponseSpec()) // <--- Проверяем статус 200 и логируем ответ
                .extract().jsonPath().getList("", FilmsResponse.class);
    }

    public FilmsResponse getFilm(int id) {
        return given()
                .spec(RequestSpec.getCommonRequestSpec()) // <--- Применяем спецификацию!
                .pathParam("id", id)
                .when()
                .get(Endpoints.FILM_BY_ID)
                .then()
                .spec(ResponseSpec.getSuccessResponseSpec()) // <--- Проверяем статус 200 и логируем ответ
                .extract().as(FilmsResponse.class);
    }
}
