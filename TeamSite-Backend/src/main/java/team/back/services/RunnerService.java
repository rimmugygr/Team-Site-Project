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
        runnerShow.setPicture(runner.getPicture());
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
            if (isNotEmptyString(runner.getFirstName())) {
                runnerInBase.setFirstName(runner.getFirstName());
            }
            if (isNotEmptyString(runner.getSecondName())) {
                runnerInBase.setSecondName(runner.getSecondName());
            }
            if (isNotEmptyString(runner.getSurname())) {
                runnerInBase.setSurname(runner.getSurname());
            }
            if (isNotEmptyString(runner.getPicture())) {
                runnerInBase.setPicture(runner.getPicture());
            }
            if (runner.getBirdDate()!=null) {
                runnerInBase.setBirdDate(runner.getBirdDate());
            }
            if (runner.getRunnerShow()!=null) {
                updateRunnerShow(runner.getRunnerShow());
            }
            runnerRepo.save(runnerInBase);
        } else {
            addNewRunner(runner);
        }
    }

    private void updateRunnerShow(RunnerShow runnerShow) {
        RunnerShow runnerShowInBase = runnerShowRepo.getOne(runnerShow.getId());
        if (isNotEmptyString(runnerShow.getFirstName())) {
            runnerShowInBase.setFirstName(runnerShow.getFirstName());
        }
        if (isNotEmptyString(runnerShow.getSecondName())) {
            runnerShowInBase.setSecondName(runnerShow.getSecondName());
        }
        if (isNotEmptyString(runnerShow.getSurname())) {
            runnerShowInBase.setSurname(runnerShow.getSurname());
        }
        if (isNotEmptyString(runnerShow.getPicture())) {
            runnerShowInBase.setPicture(runnerShow.getPicture());
        }
        if (isNotEmptyString(runnerShow.getDescription())) {
            runnerShowInBase.setDescription(runnerShow.getDescription());
        }
        runnerShowRepo.save(runnerShowInBase);

    }

    private boolean isNotEmptyString(String secondName) {
        return secondName != null && !secondName.equals("");
    }

}
