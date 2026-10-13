package org.example.api.tests;

import org.example.api.models.response.PeopleResponse;
import org.example.api.specifications.ResponseSpec;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class PeopleTest extends BaseTest {

    // по состоянию на 09.10.2026
    private static final int EXPECTED_PEOPLE_COUNT = 82;

    @Test(description = "Проверка общего количества персонажей")
    public void checkAllPersonCount() {
        List<PeopleResponse> people = peopleService.getAll();
        Assert.assertEquals(people.size(), EXPECTED_PEOPLE_COUNT);
    }

    @Test
    public void checkPersonName() {
        PeopleResponse person = peopleService.getById(1);
        Assert.assertEquals(person.getName(), "Luke Skywalker");
    }

    @Test(description = "Запрос персонажа по отсутствующему id",
            dataProvider = "invalidIds")
    public void checkPersonInvalidId(int id) {
        peopleService.getByIdRaw(id).spec(ResponseSpec.getNotFoundResponseSpec());
    }

    @DataProvider(name = "invalidIds")
    public Object[][] invalidIds() {
        return new Object[][]{
                {0},
                {84},
                {999}
        };
    }
}
