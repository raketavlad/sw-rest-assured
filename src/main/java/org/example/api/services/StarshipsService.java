package org.example.api.services;

import org.example.api.endpoints.Endpoints;
import org.example.api.models.response.StarshipsResponse;

public class StarshipsService extends BaseService<StarshipsResponse> {

    public StarshipsService() {
        super(Endpoints.STARSHIPS, StarshipsResponse.class);
    }
}
