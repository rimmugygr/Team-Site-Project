package team.back.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import team.back.models.Race;
import team.back.models.RaceStart;
import team.back.services.RaceService;
import team.back.services.RunnerService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/race")
public class RaceController {
    RaceService raceService;
    RunnerService runnerService;

    public RaceController(RaceService raceService, RunnerService runnerService) {
        this.raceService = raceService;
        this.runnerService = runnerService;
    }

    @GetMapping("")
    public List<Race> getRaces(){
        return raceService.getRaces();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void addRaces(@RequestBody Race race){
        raceService.addRace(race);
    }

    @GetMapping("/{id}")
    public Race getRace(@PathVariable("id") long id){
        return raceService.getRace(id);
    }

    @GetMapping("/start")
    public List<RaceStart> getRaceStarts() {
        return raceService.getStarts();
    }

    @GetMapping("/start/{runnerId}")
    public List<RaceStart> getRaceStarts(@PathVariable Long runnerId) {
        return raceService.getStartsByRunner(runnerService.getRunner(runnerId));
    }

    @PostMapping("/start/{runnerId}/{raceId}")
    @ResponseStatus(HttpStatus.OK)
    public void addRaceStart(@RequestBody RaceStart raceStart, @PathVariable Long runnerId, @PathVariable Long raceId) {
        raceService.addStart(raceStart, runnerId, raceId);
    }
}
