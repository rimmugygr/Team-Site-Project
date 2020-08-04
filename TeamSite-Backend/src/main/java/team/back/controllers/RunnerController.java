package team.back.controllers;

import lombok.AllArgsConstructor;
import team.back.models.Runner;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import team.back.models.RunnerShow;
import team.back.services.RunnerService;

import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/runner")
public class RunnerController {
    RunnerService runnerService;

    @GetMapping
    public List<Runner> list(){
        return runnerService.getRunners();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Runner runner){
        runnerService.addNewRunner(runner);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void put(@RequestBody Runner runner){
        runnerService.putRunner(runner);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Runner runner){
        runnerService.updateRunner(runner);
    }

    @GetMapping("/{id}")
    public Runner get(@PathVariable("id") long id){
        // return runnerService.getRunner(id);
        return runnerService.getRunnerOptional(id);
    }

    @GetMapping("/show")
    public List<RunnerShow> listRunner(){
        return runnerService.getRunnersShow();
    }

    @GetMapping("/show/{id}")
    public RunnerShow getRunner(@PathVariable("id") long id){
        return runnerService.getRunnerShow(id);
    }



}
