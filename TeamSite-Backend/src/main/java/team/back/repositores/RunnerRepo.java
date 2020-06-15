package team.back.repositores;

import team.back.models.Runner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.stream.Stream;


public interface RunnerRepo extends JpaRepository<Runner,Long> {
    Optional<Runner> getRunnerById(long id);
}
