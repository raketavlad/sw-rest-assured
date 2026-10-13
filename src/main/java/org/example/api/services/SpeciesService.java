package org.example.api.services;

import org.example.api.endpoints.Endpoints;
import org.example.api.models.response.SpeciesResponse;

public class SpeciesService extends BaseService<SpeciesResponse> {

    public SpeciesService() {
        super(Endpoints.SPECIES, SpeciesResponse.class);
    }
}
