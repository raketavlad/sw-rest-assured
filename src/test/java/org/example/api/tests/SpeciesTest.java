package org.example.api.tests;

import org.example.api.models.response.SpeciesResponse;
import org.example.api.specifications.ResponseSpec;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SpeciesTest extends BaseTest {

    @Test(description = "Проверка общего количества видов")
    public void checkAllSpeciesCount() {
        List<SpeciesResponse> species = speciesService.getAll();
        Assert.assertEquals(species.size(), 37);
    }

    @Test(description = "Проверка названия вида")
    public void checkSpeciesName() {
        SpeciesResponse species = speciesService.getById(1);
        Assert.assertEquals(species.getName(), "Human");
    }

    @Test(description = "Запрос вида по отсутствующему id",
            dataProvider = "invalidIds")
    public void checkSpeciesInvalidId(int id) {
        speciesService.getByIdRaw(id).spec(ResponseSpec.getNotFoundResponseSpec());
    }

    @DataProvider(name = "invalidIds")
    public Object[][] invalidIds() {
        return new Object[][]{
                {0},
                {38},
                {999}
        };
    }
}
