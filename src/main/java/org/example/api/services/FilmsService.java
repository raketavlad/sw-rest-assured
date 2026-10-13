package org.example.api.services;

import org.example.api.endpoints.Endpoints;
import org.example.api.models.response.FilmsResponse;

public class FilmsService extends BaseService<FilmsResponse> {

    public FilmsService() {
        super(Endpoints.FILMS, FilmsResponse.class);
    }
}
