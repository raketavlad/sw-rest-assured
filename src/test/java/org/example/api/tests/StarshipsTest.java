package org.example.api.tests;

import org.example.api.models.response.StarshipsResponse;
import org.example.api.specifications.ResponseSpec;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class StarshipsTest extends BaseTest {

    @Test(description = "Проверка общего количества звездолётов")
    public void checkAllStarshipsCount() {
        List<StarshipsResponse> starships = starshipsService.getAll();
        Assert.assertEquals(starships.size(), 36);
    }

    @Test(description = "Проверка названия звездолёта")
    public void checkStarshipName() {
        StarshipsResponse starship = starshipsService.getById(2);
        Assert.assertEquals(starship.getName(), "CR90 corvette");
    }

    @Test(description = "Запрос звездолёта по отсутствующему id",
            dataProvider = "invalidIds")
    public void checkStarshipsInvalidId(int id) {
        starshipsService.getByIdRaw(id).spec(ResponseSpec.getNotFoundResponseSpec());
    }

    @DataProvider(name = "invalidIds")
    public Object[][] invalidIds() {
        return new Object[][]{
                {0},
                {62},
                {999}
        };
    }
}
