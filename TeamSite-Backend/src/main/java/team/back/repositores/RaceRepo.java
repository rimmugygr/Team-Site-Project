package team.back.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import team.back.models.Race;


public interface RaceRepo extends JpaRepository<Race,Long> {
}
