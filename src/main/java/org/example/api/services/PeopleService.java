package org.example.api.services;

import org.example.api.endpoints.Endpoints;
import org.example.api.models.response.PeopleResponse;

public class PeopleService extends BaseService<PeopleResponse> {

    public PeopleService() {
        super(Endpoints.PEOPLE, PeopleResponse.class);
    }
}
