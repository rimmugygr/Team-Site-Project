package team.back.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import team.back.models.Runner;
import team.back.models.RunnerShow;
import team.back.repositores.RunnerRepo;
import team.back.repositores.RunnerShowRepo;

import java.util.List;

@Service
public class RunnerService {
    RunnerRepo runnerRepo;
    RunnerShowRepo runnerShowRepo;

    public RunnerService(RunnerRepo runnerRepo, RunnerShowRepo runnerShowRepo) {
        this.runnerRepo = runnerRepo;
        this.runnerShowRepo = runnerShowRepo;
    }

    public void addNewRunner(Runner runner) {
        RunnerShow runnerShow = new RunnerShow();
        runnerShow.setFirstName(runner.getFirstName());
        runnerShow.setSecondName(runner.getSecondName());
        runnerShow.setSurname(runner.getSurname());
        runner.setRunnerShow(runnerShow);
        runnerRepo.save(runner);
    }

    public List<Runner> getRunners() {
        return runnerRepo.findAll();
    }

    public Runner getRunner(long id) {
        return runnerRepo.getOne(id);
    }

    public Runner getRunnerOptional(long id) {
        Runner defaultRunner = new Runner();
        defaultRunner.setFirstName("DEFAULT");
        defaultRunner.setSurname("DEFAULT");
        defaultRunner.setSecondName("DEFAULT");
        return runnerRepo.getRunnerById(id).orElse(defaultRunner);
    }
    public List<RunnerShow> getRunnersShow() {
        return runnerShowRepo.findAll();
    }

    public RunnerShow getRunnerShow(long id) {
        return runnerShowRepo.getOne(id);
    }

    public void putRunner(Runner runner) {
        runnerRepo.save(runner);
    }

    public void updateRunner(Runner runner) {
        if(runnerRepo.existsById(runner.getId())){
            Runner runnerInBase = runnerRepo.getOne(runner.getId());
            if (runner.getFirstName()!=null && !runner.getFirstName().equals("")) {
                runnerInBase.setFirstName(runner.getFirstName());
            }
            if (runner.getSecondName()!=null && !runner.getSecondName().equals("")) {
                runnerInBase.setSecondName(runner.getSecondName());
            }
            if (runner.getSurname()!=null && !runner.getSurname().equals("")) {
                runnerInBase.setSurname(runner.getSurname());
            }
            if (runner.getBirdDate()!=null) {
                runnerInBase.setBirdDate(runner.getBirdDate());
            }
            runnerRepo.save(runnerInBase);
        } else {
            addNewRunner(runner);
        }
    }
}
