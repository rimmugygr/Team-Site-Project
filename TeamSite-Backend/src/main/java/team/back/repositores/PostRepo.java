package team.back.repositores;

import team.back.models.Post;
import team.back.models.Runner;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepo extends JpaRepository<Post,Long> {

    
}
