package team.back.models;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class RaceStart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String description;
    @ManyToOne
    @JoinColumn(name="runner_id")
    @JsonUnwrapped(suffix = "Runner")
    @JsonIgnoreProperties( {"firstName","secondName","picture","birdDate","runnerShow"})
    private Runner runner;
    @ManyToOne
    @JoinColumn(name="race_id")
    @JsonBackReference
    private Race race;
}
