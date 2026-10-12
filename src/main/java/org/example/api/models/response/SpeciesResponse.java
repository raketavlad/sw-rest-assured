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
public class SpeciesResponse {
    public String name;
    public String classification;
    public String designation;
    public String average_height;
    @JsonProperty("skin_colors")
    public String skinColors;
    @JsonProperty("hair_colors")
    public String hairColors;
    @JsonProperty("eye_colors")
    public String eyeColors;
    @JsonProperty("average_lifespan")
    public String averageLifespan;
    public Object homeworld;
    public String language;
    public List<String> people;
    public List<String> films;
    public Instant created;
    public Instant edited;
    public String url;
}
