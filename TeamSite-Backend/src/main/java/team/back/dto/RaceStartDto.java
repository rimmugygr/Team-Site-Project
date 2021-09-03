package team.back.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.back.models.Race;
import team.back.models.Runner;
import team.back.models.Status;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RaceStartDto {
    private Long id;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String description;
    @JsonUnwrapped(suffix = "Runner")
    @JsonIgnoreProperties( {"firstName","secondName","picture","birdDate","runnerShow"})
    private Runner runner;
    private Race race;
}
