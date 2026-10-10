package org.example.api.tests;

import org.example.api.endpoints.Endpoints;
import org.example.api.models.response.FilmsResponse;
import org.example.api.specifications.RequestSpec;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class FilmsTest extends BaseTest {

    @Test(description = "Проверка общего количества фильмов")
    public void checkAllFilmsCount() {
        List<FilmsResponse> people = filmsService.getAllFilms();
        Assert.assertEquals(people.size(), 6);
    }

    @Test(description = "Проверка названия фильма")
    public void checkFilmTitle() {
        FilmsResponse film = filmsService.getFilm(1);
        Assert.assertEquals(film.getTitle(), "A New Hope");
    }

    @Test(description = "Запрос фильма по отсутствующему id",
            dataProvider = "invalidIds")
    public void checkPersonInvalidId(int id) {
        given()
                .spec(RequestSpec.getCommonRequestSpec())
                .pathParam("id", id)
                .when()
                .get(Endpoints.FILM_BY_ID)
                .then()
                .statusCode(404);
    }

    @DataProvider(name = "invalidIds")
    public Object[][] invalidIds() {
        return new Object[][]{
                {0},
                {7},
                {999}
        };
    }
}
