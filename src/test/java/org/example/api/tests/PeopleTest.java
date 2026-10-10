package org.example.api.tests;

import io.restassured.http.ContentType;
import org.example.api.config.ConfigProvider;
import org.example.api.endpoints.Endpoints;
import org.example.api.models.response.PeopleResponse;
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
        List<PeopleResponse> people = peopleService.getAllPerson()
                .body().jsonPath().getList("", PeopleResponse.class);
        Assert.assertEquals(people.size(), EXPECTED_PEOPLE_COUNT);

    }

    @Test
    public void checkPersonName() {
        PeopleResponse person = peopleService.getPerson(1).as(PeopleResponse.class);
        Assert.assertEquals(person.getName(), "Luke Skywalker");
        System.out.println(person.getCreated());
    }

    @Test(description = "Запрос персонажа по отсутствующему id",
    dataProvider = "testInvalidId")
    public void checkPersonInvalidId(int id) {
        given()
                .contentType(ContentType.JSON)
                .baseUri(ConfigProvider.BASE_URL)
                .pathParam("id", id)
                .when()
                .get(Endpoints.PERSON_BY_ID)
                .then()
                .statusCode(404);
    }

    @DataProvider(name = "testInvalidId")
    public Object[][] getId() {
        return new Object[][]{
                {0},
                {84},
                {999}
        };
    }
}
