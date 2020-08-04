package team.back.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import team.back.models.Race;
import team.back.models.RaceStart;
import team.back.services.RaceService;
import team.back.services.RunnerService;

import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/race")
public class RaceController {
    RaceService raceService;
    RunnerService runnerService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Race> getRaces(){
        return raceService.getRaces();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRaces(@RequestBody Race race){
        raceService.addRace(race);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Race getRace(@PathVariable("id") long id){
        return raceService.getRace(id);
    }

    @GetMapping("/start")
    @ResponseStatus(HttpStatus.OK)
    public List<RaceStart> getRaceStarts() {
        return raceService.getStarts();
    }

    @GetMapping("/start/{runnerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<RaceStart> getRaceStarts(@PathVariable Long runnerId) {
        return raceService.getStartsByRunner(runnerService.getRunner(runnerId));
    }

    @PostMapping("/start/{runnerId}/{raceId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRaceStart(@RequestBody RaceStart raceStart, @PathVariable Long runnerId, @PathVariable Long raceId) {
        raceService.addStart(raceStart, runnerId, raceId);
    }

    @PatchMapping("/start/{runnerId}/{raceId}")
    @ResponseStatus(HttpStatus.OK)
    public void editRaceStart(@RequestBody RaceStart raceStart, @PathVariable Long runnerId, @PathVariable Long raceId) {
        raceService.editStart(raceStart, runnerId, raceId);
    }
}
