package team.back.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import team.back.models.Race;
import team.back.models.RunnerShow;


public interface RaceRepo extends JpaRepository<Race,Long> {
}
