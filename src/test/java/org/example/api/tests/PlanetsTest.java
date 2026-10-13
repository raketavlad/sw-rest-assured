package org.example.api.tests;

import org.example.api.models.response.PlanetsResponse;
import org.example.api.specifications.ResponseSpec;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class PlanetsTest extends BaseTest {

    @Test(description = "Проверка общего количества планет")
    public void checkAllPlanetsCount() {
        List<PlanetsResponse> planets = planetsService.getAll();
        Assert.assertEquals(planets.size(), 60);
    }

    @Test(description = "Проверка названия планеты")
    public void checkPlanetName() {
        PlanetsResponse planet = planetsService.getById(1);
        Assert.assertEquals(planet.getName(), "Tatooine");
    }

    @Test(description = "Запрос планеты по отсутствующему id",
            dataProvider = "invalidIds")
    public void checkPlanetsInvalidId(int id) {
        planetsService.getByIdRaw(id).spec(ResponseSpec.getNotFoundResponseSpec());
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
