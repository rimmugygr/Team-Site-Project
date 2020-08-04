package team.back.repositores;

import team.back.models.Runner;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface RunnerRepo extends JpaRepository<Runner,Long> {
    Optional<Runner> getRunnerById(long id);
}
