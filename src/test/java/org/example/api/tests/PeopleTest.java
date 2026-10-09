package org.example.api.tests;

import org.example.api.models.response.PeopleResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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
}
