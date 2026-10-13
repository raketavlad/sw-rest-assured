package org.example.api.tests;

import org.example.api.models.response.FilmsResponse;
import org.example.api.specifications.ResponseSpec;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class FilmsTest extends BaseTest {

    @Test(description = "Проверка общего количества фильмов")
    public void checkAllFilmsCount() {
        List<FilmsResponse> people = filmsService.getAll();
        Assert.assertEquals(people.size(), 6);
    }

    @Test(description = "Проверка названия фильма")
    public void checkFilmTitle() {
        FilmsResponse film = filmsService.getById(1);
        Assert.assertEquals(film.getTitle(), "A New Hope");
    }

    @Test(description = "Запрос фильма по отсутствующему id",
            dataProvider = "invalidIds")
    public void checkFilmInvalidId(int id) {
        filmsService.getByIdRaw(id).spec(ResponseSpec.getNotFoundResponseSpec());
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
