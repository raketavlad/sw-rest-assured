package org.example.api.tests;

import org.example.api.endpoints.Endpoints;
import org.example.api.models.response.PeopleResponse;
import org.example.api.specifications.RequestSpec;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PeopleTest extends BaseTest {

    // по состоянию на 09.10.2026
    private static final int EXPECTED_PEOPLE_COUNT = 82;

    @Test(description = "Проверка общего количества персонажей")
    public void checkAllPersonCount() {
        List<PeopleResponse> people = peopleService.getAllPerson();
        Assert.assertEquals(people.size(), EXPECTED_PEOPLE_COUNT);
    }

    @Test
    public void checkPersonName() {
        PeopleResponse person = peopleService.getPerson(1);
        Assert.assertEquals(person.getName(), "Luke Skywalker");
    }

    @Test(description = "Запрос персонажа по отсутствующему id",
            dataProvider = "invalidIds")
    public void checkPersonInvalidId(int id) {
        given()
                .spec(RequestSpec.getCommonRequestSpec())
                .pathParam("id", id)
                .when()
                .get(Endpoints.PERSON_BY_ID)
                .then()
                .statusCode(404);
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
