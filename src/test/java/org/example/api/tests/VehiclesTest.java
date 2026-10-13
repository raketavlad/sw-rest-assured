package org.example.api.tests;

import org.example.api.models.response.VehiclesResponse;
import org.example.api.specifications.ResponseSpec;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class VehiclesTest extends BaseTest {

    @Test(description = "Проверка общего количества транспортных средств")
    public void checkAllVehiclesCount() {
        List<VehiclesResponse> vehicles = vehiclesService.getAll();
        Assert.assertEquals(vehicles.size(), 39);
    }

    @Test(description = "Проверка названия транспортного средства")
    public void checkVehicleName() {
        VehiclesResponse vehicle = vehiclesService.getById(4);
        Assert.assertEquals(vehicle.getName(), "Sand Crawler");
    }

    @Test(description = "Запрос транспортного средства по отсутствующему id",
            dataProvider = "invalidIds")
    public void checkVehiclesInvalidId(int id) {
        vehiclesService.getByIdRaw(id).spec(ResponseSpec.getNotFoundResponseSpec());
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
