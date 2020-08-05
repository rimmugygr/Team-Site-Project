package team.back.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import team.back.models.Post;
import team.back.services.PostService;
import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Post> list(){
        return postService.getPosts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post get(@PathVariable("id") long id){
        return postService.getPost(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Post post){
        postService.addPost(post);
    }

    @PostMapping("/runner/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Post post, @PathVariable("id") long id){
        postService.addPost(post, id);
    }

}
