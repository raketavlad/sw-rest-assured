package org.example.api.tests;

import org.example.api.endpoints.Endpoints;
import org.example.api.models.response.VehiclesResponse;
import org.example.api.specifications.RequestSpec;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class VehiclesTest extends BaseTest {

    @Test(description = "Проверка общего количества транспортных средств")
    public void checkAllStarshipsCount() {
        List<VehiclesResponse> vehicles = vehiclesService.getAll();
        Assert.assertEquals(vehicles.size(), 39);
    }

    @Test(description = "Проверка названия транспортного средства")
    public void checkStarshipName() {
        VehiclesResponse vehicle = vehiclesService.getById(4);
        Assert.assertEquals(vehicle.getName(), "Sand Crawler");
    }

    @Test(description = "Запрос транспортного средства по отсутствующему id",
            dataProvider = "invalidIds")
    public void checkStarshipsInvalidId(int id) {
        given()
                .spec(RequestSpec.getCommonRequestSpec())
                .pathParam("id", id)
                .when()
                .get(Endpoints.VEHICLE_BY_ID)
                .then()
                .statusCode(404);
    }

    @DataProvider(name = "invalidIds")
    public Object[][] invalidIds() {
        return new Object[][]{
                {0},
                {87},
                {999}
        };
    }
}
