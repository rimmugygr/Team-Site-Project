package team.back.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@EqualsAndHashCode
@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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

    public Runner(Long id) {
        this.id = id;
    }
}
