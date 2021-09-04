package team.back.controllers;

import lombok.AllArgsConstructor;
import team.back.dto.RunnerDto;
import team.back.dto.RunnerShowDto;
import team.back.mappers.RunnerMapper;
import team.back.mappers.RunnerShowMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import team.back.services.RunnerService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/runner")
public class RunnerController {
    private final RunnerService runnerService;
    private final RunnerMapper runnerMapper;
    private final RunnerShowMapper runnerShowMapper;

    @GetMapping
    public List<RunnerDto> list(){
        return runnerService.getRunners().stream()
                .map(runnerMapper::map)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody RunnerDto runnerDto){
        runnerService.addNewRunner(runnerMapper.map(runnerDto));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void put(@RequestBody RunnerDto runnerDto){
        runnerService.putRunner(runnerMapper.map(runnerDto));
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody RunnerDto runnerDto){
        runnerService.updateRunner(runnerMapper.map(runnerDto));
    }

    @GetMapping("/{id}")
    public RunnerDto get(@PathVariable("id") long id){
        return runnerMapper.map(runnerService.getRunnerOptional(id));
    }

    @GetMapping("/show")
    public List<RunnerShowDto> listRunner(){
        return runnerService.getRunnersShow().stream()
                .map(runnerShowMapper::map)
                .collect(Collectors.toList());
    }

    @GetMapping("/show/{id}")
    public RunnerShowDto getRunner(@PathVariable("id") long id){
        return runnerShowMapper.map(runnerService.getRunnerShow(id));
    }



}
