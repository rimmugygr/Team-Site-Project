package team.back.models;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class RaceStart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Status status;
    private String description;
    @ManyToOne
    @JoinColumn(name="runner_id")
    @JsonIgnore
    private Runner runner;
    private Long runnerIdStart;
    @ManyToOne
    @JoinColumn(name="race_id")
    @JsonBackReference
    private Race race;

    public Long getRunnerIdStart() {
        return runnerIdStart;
    }

    public void setRunnerIdStart(Long runnerIdStart) {
        this.runnerIdStart = runnerIdStart;
    }

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
