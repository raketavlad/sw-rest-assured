package org.example.api.tests;

import org.example.api.endpoints.Endpoints;
import org.example.api.models.response.PlanetsResponse;
import org.example.api.specifications.RequestSpec;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PlanetsTest extends BaseTest {

    @Test(description = "Проверка общего количества планет")
    public void checkAllPlanetsCount() {
        List<PlanetsResponse> planets = planetsService.getAllPlanets();
        Assert.assertEquals(planets.size(), 60);
    }

    @Test(description = "Проверка названия планеты")
    public void checkPlanetName() {
        PlanetsResponse planet = planetsService.getPlanet(1);
        Assert.assertEquals(planet.getName(), "Tatooine");
    }

    @Test(description = "Запрос планеты по отсутствующему id",
            dataProvider = "invalidIds")
    public void checkPlanetsInvalidId(int id) {
        given()
                .spec(RequestSpec.getCommonRequestSpec())
                .pathParam("id", id)
                .when()
                .get(Endpoints.PLANET_BY_ID)
                .then()
                .statusCode(404);
    }

    @DataProvider(name = "invalidIds")
    public Object[][] invalidIds() {
        return new Object[][]{
                {0},
                {61},
                {999}
        };
    }
}
