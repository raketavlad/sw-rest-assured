package org.example.api.tests;

import io.restassured.http.ContentType;
import org.example.api.models.response.PeopleResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PeopleTest extends BaseTest {

    private final static String BASE_URL = "https://swapi.info/api";

    @Test
    public void checkPeople() {
        List<PeopleResponse> people = given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URL + "/people")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .contentType("application/json")
                .extract().body().jsonPath().getList("", PeopleResponse.class);


        PeopleResponse people1 = people.get(0);
        System.out.println(people1.getName());
        System.out.println("Created " + people1.getCreated());
        System.out.println("Edited " + people1.getEdited());
        Assert.assertEquals(people1.getName(), "Luke Skywalker");
    }

    @Test
    public void checkTest() {
        String header = given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URL + "/people")
                .then()
                .log().ifValidationFails()
                .header("Cf-Cache-Status","HIT")
                .extract().header("Cf-Cache-Status");
    }

    @Test
    public void checkTestSecond() {
        PeopleResponse luke = peopleService.getPerson(1).as(PeopleResponse.class);
        System.out.println(luke.getName());
    }

    @Test
    public void checkAllPersonCount() {
        List<PeopleResponse> people = peopleService.getAllPerson()
                .body().jsonPath().getList("", PeopleResponse.class);
        Assert.assertEquals(people.size(), 82);

    }
}
