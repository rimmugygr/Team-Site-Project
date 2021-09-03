package team.back.mappers;

import org.mapstruct.Mapper;
import team.back.dto.RunnerDto;
import team.back.models.Runner;

@Mapper(componentModel = "spring")
public interface RunnerMapper {
    RunnerDto map(Runner runner);
    Runner map(RunnerDto runnerDto);

}
