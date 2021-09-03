package team.back.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RunnerShowDto {
    private Long id;
    private String firstName;
    private String secondName;
    private String surname;
    private String picture;
    private String description;
}
