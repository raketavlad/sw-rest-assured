package org.example.api.services;

import org.example.api.endpoints.Endpoints;
import org.example.api.models.response.PlanetsResponse;

public class PlanetsService extends BaseService<PlanetsResponse> {

    public PlanetsService() {
        super(Endpoints.PLANETS, PlanetsResponse.class);
    }
}
