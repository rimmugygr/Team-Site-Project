package team.back.controllers;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import team.back.models.Post;
import team.back.models.Runner;
import team.back.repositores.PostRepo;
import team.back.repositores.RunnerRepo;
import team.back.services.PostService;

import javax.persistence.PrePersist;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/post")
public class PostController {
    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> list(){
        return postService.getPosts();
    }

    @GetMapping("/{id}")
    public Post get(@PathVariable("id") long id){
        return postService.getPost(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Post post){
        postService.addPost(post);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Post post, @PathVariable("id") long id){
        postService.addPost(post, id);
    }

}
