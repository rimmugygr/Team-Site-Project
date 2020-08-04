package team.back.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import team.back.models.Race;
import team.back.models.RaceStart;
import team.back.models.Runner;
import team.back.repositores.RaceRepo;
import team.back.repositores.RaceStartRepo;

import java.util.List;

@AllArgsConstructor
@Service
public class RaceService {
    RunnerService runnerService;
    RaceStartRepo raceStartRepo;
    RaceRepo raceRepo;

    public List<RaceStart> getStarts(){
        return raceStartRepo.findAll();
    }

    public List<RaceStart> getStartsByRunner(Runner runner){
        return raceStartRepo.getRaceStartsByRunner(runner);
    }

    public void addStart(RaceStart raceStart,Long runnerId , Long raceId){
        if (raceStartRepo.existsByRaceAndRunner(new Race(raceId), new Runner(runnerId))) {
            editStart(raceStart,runnerId,raceId);
        } else {
            raceStart.setRunner(runnerService.getRunner(runnerId));
            raceStart.setRace(this.getRace(raceId));
            raceStartRepo.save(raceStart);
        }
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

    public void editStart(RaceStart raceStartUpdate, Long runnerId, Long raceId) {
        RaceStart raceStartDB = raceStartRepo.getRaceStartByRaceAndRunner(new Race(raceId), new Runner(runnerId));
        raceStartDB.setStatus(raceStartUpdate.getStatus());
        raceStartDB.setDescription(raceStartUpdate.getDescription());
        raceStartRepo.save(raceStartDB);
    }
}
