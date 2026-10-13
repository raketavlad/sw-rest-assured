package org.example.api.tests;

import io.restassured.RestAssured;
import org.example.api.services.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected PeopleService peopleService;
    protected FilmsService filmsService;
    protected PlanetsService planetsService;
    protected SpeciesService speciesService;
    protected StarshipsService starshipsService;
    protected VehiclesService vehiclesService;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @BeforeClass
    public void setUp() {
        peopleService = new PeopleService();
        filmsService = new FilmsService();
        planetsService = new PlanetsService();
        speciesService = new SpeciesService();
        starshipsService = new StarshipsService();
        vehiclesService = new VehiclesService();
    }
}
