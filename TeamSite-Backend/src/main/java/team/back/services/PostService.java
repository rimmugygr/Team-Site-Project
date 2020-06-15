package team.back.services;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import team.back.models.Post;
import team.back.repositores.PostRepo;

import java.util.Date;
import java.util.List;

@Service
public class PostService {
    PostRepo postRepo;
    RunnerService runnerService;

    public PostService(PostRepo postRepo, RunnerService runnerService) {
        this.postRepo = postRepo;
        this.runnerService = runnerService;
    }

    public List<Post> getPosts() {
        return postRepo.findAll(Sort.by(Sort.Direction.ASC, "date"));
    }

    public Post getPost(long id) {
        return postRepo.getOne(id);
    }

    public void addPost(Post post) {
        post.setDate(new Date());
        postRepo.save(post);
    }

    public void addPost(Post post, long id) {
        post.setDate(new Date());
        post.setRunner(runnerService.getRunner(id));
        postRepo.save(post);
    }
}
