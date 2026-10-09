package org.example.api.tests;

import org.example.api.services.PeopleService;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected PeopleService peopleService;

    @BeforeClass
    public void setUp() {
        peopleService = new PeopleService();
    }
}
