package team.back.services;

import org.springframework.stereotype.Service;
import team.back.models.Race;
import team.back.models.RaceStart;
import team.back.models.Runner;
import team.back.repositores.RaceRepo;
import team.back.repositores.RaceStartRepo;

import java.util.List;

@Service
public class RaceService {
    RunnerService runnerService;
    RaceStartRepo raceStartRepo;
    RaceRepo raceRepo;

    public RaceService(RunnerService runnerService, RaceStartRepo raceStartRepo, RaceRepo raceRepo) {
        this.runnerService = runnerService;
        this.raceStartRepo = raceStartRepo;
        this.raceRepo = raceRepo;
    }

    public List<RaceStart> getStarts(){
        return raceStartRepo.findAll();
    }

    public List<RaceStart> getStartsByRunner(Runner runner){
        return raceStartRepo.getRaceStartsByRunner(runner);
    }

    public void addStart(RaceStart raceStart,Long runnerId , Long raceId){
        raceStart.setRunner(runnerService.getRunner(runnerId));
        raceStart.setRunnerIdStart(runnerId);
        raceStart.setRace(this.getRace(raceId));
        raceStartRepo.save(raceStart);
    }

    public List<Race> getRaces(){
        return raceRepo.findAll();
    }

    public Race getRace(Long raceId){
        return raceRepo.getOne(raceId);
    }

    public void addRace(Race race){
        raceRepo.save(race);
    }

}
