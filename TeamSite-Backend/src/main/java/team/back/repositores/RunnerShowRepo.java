package team.back.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import team.back.models.RunnerShow;


public interface RunnerShowRepo extends JpaRepository<RunnerShow,Long> {
}
