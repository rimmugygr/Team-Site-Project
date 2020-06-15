package team.back.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import team.back.models.RaceStart;
import team.back.models.Runner;

import java.util.List;


public interface RaceStartRepo extends JpaRepository<RaceStart,Long> {
    public List<RaceStart> getRaceStartsByRunner(Runner runner);
}
