package team.back.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import team.back.models.RunnerShow;

import java.util.Date;

@EqualsAndHashCode
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RunnerDto {
    private Long id;
    private String firstName;
    private String secondName;
    private String surname;
    private String picture;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date birdDate;
    private RunnerShow runnerShow;
}
