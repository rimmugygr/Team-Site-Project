package team.back.services;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import team.back.models.Post;
import team.back.models.Runner;
import team.back.repositores.PostRepo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Import({PostService.class})
@ExtendWith(SpringExtension.class)
class PostServiceTest {
    @MockBean
    PostRepo postRepoMock;
    @MockBean
    RunnerService runnerServiceMock;
    @Autowired
    PostService postService;

    @Test
    void shouldGetPostFromRepositoryById() {
        //given
        long anyPostId = 1L;
        Post anyPost = Post.builder()
                .id(anyPostId)
                .build();
        Mockito.when(postRepoMock.getOne(anyPostId))
                .thenReturn(anyPost);
        //when
        Post resultPost = postService.getPost(anyPostId);
        //then
        MatcherAssert.assertThat(resultPost, Matchers.notNullValue());
        MatcherAssert.assertThat(resultPost.getId(), Matchers.is(anyPostId));
    }
    @Test
    void shouldGetPostsFromRepository() {
        //given
        List<Post> anyPostList = new ArrayList<>();
        Post anyPost1 = Post.builder().id(1L).build();
        Post anyPost2 = Post.builder().id(2L).build();
        anyPostList.add(anyPost1);
        anyPostList.add(anyPost2);
        Mockito.when(postRepoMock.findAll(Sort.by(Sort.Direction.ASC, "date")))
                .thenReturn(anyPostList);
        //when
        List<Post> resultPostList = postService.getPosts();
        //then
        MatcherAssert.assertThat(resultPostList, Matchers.notNullValue());
        MatcherAssert.assertThat(resultPostList.size(), Matchers.is(anyPostList.size()));
    }
    @Test
    void shouldAddPostToRepository() {
        //given
        Post anyPost = Post.builder().id(1L).description("description").build();
        //when
        postService.addPost(anyPost);
        //then
        Mockito.verify(postRepoMock).save(anyPost);
    }
    @Test
    void shouldAddPostWithRunnerIdToRepository() {
        //given
        Post anyPost = Post.builder().id(1L).build();
        System.out.println(anyPost);
        long anyRunnerId = 2L;
        Runner anyRunner = Runner.builder().id(anyRunnerId).firstName("name").build();
        Mockito.when(runnerServiceMock.getRunner(anyRunnerId))
                .thenReturn(anyRunner);
        Post resultPost = Post.builder().id(1L)
                .date(LocalDate.now())
                .runner(Runner.builder().id(anyRunnerId).firstName("name").build())
                .build();
        //when
        postService.addPost(anyPost, anyRunnerId);
        //then
        Mockito.verify(postRepoMock).save(resultPost);
    }
}
