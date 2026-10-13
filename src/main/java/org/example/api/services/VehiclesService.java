package org.example.api.services;

import org.example.api.endpoints.Endpoints;
import org.example.api.models.response.VehiclesResponse;

public class VehiclesService extends BaseService<VehiclesResponse> {

    public VehiclesService() {
        super(Endpoints.VEHICLES, VehiclesResponse.class);
    }
}
