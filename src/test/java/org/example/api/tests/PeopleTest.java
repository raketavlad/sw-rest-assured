package org.example.api.tests;

import org.example.api.models.response.PeopleResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PeopleTest extends BaseTest {

    @Test(description = "Проверка общего количества персонажей")
    public void checkAllPersonCount() {
        List<PeopleResponse> people = peopleService.getAllPerson()
                .body().jsonPath().getList("", PeopleResponse.class);
        Assert.assertEquals(people.size(), 82);

    }

    @Test
    public void checkPersonName() {
        PeopleResponse person = peopleService.getPerson(1).as(PeopleResponse.class);
        Assert.assertEquals(person.getName(), "Luke Skywalker");
    }
}
