package team.back.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Runner {
    @Id
    private Long id;
    private String firstName;
    private String secondName;
    private String surname;
    private String picture;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date birdDate;
    @OneToOne(targetEntity = RunnerShow.class, cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private RunnerShow runnerShow;
    @OneToMany(mappedBy = "race")
    @JsonIgnore
    private List<RaceStart> raceStarts;

    public Runner() {
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<RaceStart> getRaceStarts() {
        return raceStarts;
    }

    public void setRaceStarts(List<RaceStart> raceStarts) {
        this.raceStarts = raceStarts;
    }

    public RunnerShow getRunnerShow() {
        return runnerShow;
    }

    public void setRunnerShow(RunnerShow runnerShow) {
        this.runnerShow = runnerShow;
    }

    public Date getBirdDate() {
        return birdDate;
    }

    public void setBirdDate(Date birdDate) {
        this.birdDate = birdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Runner{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", surname='" + surname + '\'' +
                ", picture='" + picture + '\'' +
                ", birdDate=" + birdDate +
                ", runnerShow=" + runnerShow +
                ", raceStarts=" + raceStarts +
                '}';
    }
}
