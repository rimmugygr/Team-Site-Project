package team.back.mappers;

import org.mapstruct.Mapper;
import team.back.dto.RunnerShowDto;
import team.back.models.RunnerShow;

@Mapper(componentModel = "spring")
public interface RunnerShowMapper {
    RunnerShow map(RunnerShowDto runnerShowDto);
    RunnerShowDto map(RunnerShow runnerShow);
}
