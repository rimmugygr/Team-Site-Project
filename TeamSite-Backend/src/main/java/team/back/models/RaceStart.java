package team.back.models;



import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class RaceStart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Enumerated(EnumType.STRING)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Runner getRunner() {
        return runner;
    }

    public void setRunner(Runner runner) {
        this.runner = runner;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
