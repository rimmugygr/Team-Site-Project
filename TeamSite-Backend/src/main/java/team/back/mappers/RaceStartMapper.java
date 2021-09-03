package team.back.mappers;

import org.mapstruct.Mapper;
import team.back.dto.RaceStartDto;
import team.back.models.RaceStart;

@Mapper(componentModel = "spring")
public interface RaceStartMapper {
    RaceStart map(RaceStartDto raceStartDto);
    RaceStartDto map(RaceStart raceStart);
}
