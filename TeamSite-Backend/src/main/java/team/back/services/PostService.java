package team.back.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import team.back.models.Post;
import team.back.repositores.PostRepo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class PostService {
    private final PostRepo postRepo;
    private final RunnerService runnerService;

    public List<Post> getPosts() {
        return postRepo.findAll(Sort.by(Sort.Direction.ASC, "date"));
    }

    public Post getPost(long id) {
        return postRepo.getOne(id);
    }

    public void addPost(Post post) {
        post.setDate(LocalDate.now());
        postRepo.save(post);
    }

    public void addPost(Post post, long id) {
        post.setDate(LocalDate.now());
        post.setRunner(runnerService.getRunner(id));
        postRepo.save(post);
    }
}
