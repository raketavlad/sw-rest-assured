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
public class PlanetsResponse {
    public String name;
    @JsonProperty("rotation_period")
    public String rotationPeriod;
    @JsonProperty("orbital_period")
    public String orbitalPeriod;
    public String diameter;
    public String climate;
    public String gravity;
    public String terrain;
    @JsonProperty("surface_water")
    public String surfaceWater;
    public String population;
    public List<String> residents;
    public List<String> films;
    public Instant created;
    public Instant edited;
    public String url;
}
