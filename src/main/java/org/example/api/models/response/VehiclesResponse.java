package org.example.api.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehiclesResponse {
    public String name;
    public String model;
    public String manufacturer;
    @JsonProperty("cost_in_credits")
    public String costInCredits;
    public String length;
    @JsonProperty("max_atmosphering_speed")
    public String maxAtmospheringSpeed;
    public String crew;
    public String passengers;
    @JsonProperty("cargo_capacity")
    public String cargoCapacity;
    public String consumables;
    @JsonProperty("vehicle_class")
    public String vehicleClass;
    public List<Object> pilots;
    public List<String> films;
    public Instant created;
    public Instant edited;
    public String url;
}
