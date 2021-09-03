package team.back.mappers;

import org.mapstruct.Mapper;
import team.back.dto.RaceDto;
import team.back.models.Race;

@Mapper(componentModel = "spring")
public interface RaceMapper {
    RaceDto map(Race race);
    Race map(RaceDto raceDto);
}
