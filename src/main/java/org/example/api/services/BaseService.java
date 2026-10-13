package org.example.api.services;

import org.example.api.specifications.RequestSpec;
import org.example.api.specifications.ResponseSpec;

import java.util.List;

import static io.restassured.RestAssured.given;

public abstract class BaseService<T> {

    private final String resourcePath;
    private final Class<T> type;

    protected BaseService(String resourcePath, Class<T> type) {
        this.resourcePath = resourcePath;
        this.type = type;
    }

    public List<T> getAll() {
        return given()
                .spec(RequestSpec.getCommonRequestSpec()) // <--- Применяем спецификацию!
                .when()
                .get(resourcePath)
                .then()
                .spec(ResponseSpec.getSuccessResponseSpec()) // <--- Проверяем статус 200 и логируем ответ
                .extract().jsonPath().getList("", type);
    }

    public T getById(int id) {
        return given()
                .spec(RequestSpec.getCommonRequestSpec()) // <--- Применяем спецификацию!
                .pathParam("id", id)
                .when()
                .get(resourcePath + "/{id}")
                .then()
                .spec(ResponseSpec.getSuccessResponseSpec()) // <--- Проверяем статус 200 и логируем ответ
                .extract().as(type);
    }
}
