package team.back.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import team.back.dto.PostDto;
import team.back.mappers.PostMapper;
import team.back.services.PostService;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;
    private final PostMapper postMapper;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> list(){
        return postService.getPosts().stream()
                .map(postMapper::map)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto get(@PathVariable("id") long id){
        return postMapper.map(postService.getPost(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PostDto postDto){
        postService.addPost(postMapper.map(postDto));
    }

    @PostMapping("/runner/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PostDto postDto, @PathVariable("id") long id){
        postService.addPost(postMapper.map(postDto), id);
    }

}
