package team.back.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import team.back.dto.RaceDto;
import team.back.dto.RaceStartDto;
import team.back.mappers.RaceMapper;
import team.back.mappers.RaceStartMapper;
import team.back.services.RaceService;
import team.back.services.RunnerService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/race")
public class RaceController {
    private final RaceService raceService;
    private final RunnerService runnerService;
    private final RaceMapper raceMapper;
    private final RaceStartMapper raceStartMapper;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<RaceDto> getRaces(){
        return raceService.getRaces().stream()
                .map(raceMapper::map)
                .collect(Collectors.toList());
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRaces(@RequestBody RaceDto raceDto){
        raceService.addRace(raceMapper.map(raceDto));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RaceDto getRace(@PathVariable("id") long id){
        return raceMapper.map(raceService.getRace(id));
    }

    @GetMapping("/start")
    @ResponseStatus(HttpStatus.OK)
    public List<RaceStartDto> getRaceStarts() {
        return raceService.getStarts().stream()
                .map(raceStartMapper::map)
                .collect(Collectors.toList());
    }

    @GetMapping("/start/{runnerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<RaceStartDto> getRaceStarts(@PathVariable Long runnerId) {
        return raceService.getStartsByRunner(runnerService.getRunner(runnerId)).stream()
                .map(raceStartMapper::map)
                .collect(Collectors.toList());
    }

    @PostMapping("/start/{runnerId}/{raceId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRaceStart(@RequestBody RaceStartDto raceStartDto, @PathVariable Long runnerId, @PathVariable Long raceId) {
        raceService.addStart(raceStartMapper.map(raceStartDto), runnerId, raceId);
    }

    @PatchMapping("/start/{runnerId}/{raceId}")
    @ResponseStatus(HttpStatus.OK)
    public void editRaceStart(@RequestBody RaceStartDto raceStartDto, @PathVariable Long runnerId, @PathVariable Long raceId) {
        raceService.editStart(raceStartMapper.map(raceStartDto), runnerId, raceId);
    }
}
