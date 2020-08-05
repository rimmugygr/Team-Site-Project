package team.back.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import team.back.models.Post;
import team.back.models.Runner;
import team.back.services.PostService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@WebMvcTest(controllers = {PostController.class})
class PostControllerTest {
    @Autowired
    MockMvc mvc;
    @MockBean
    PostService postService;
    @Autowired
    ObjectMapper objectMapper;

    ResultActions result;
    long id;
    List<Post> anyPostList;
    String anyPostListJson;
    Post anyPost;
    String anyPostJson;
    Post anyPost2;

    @DisplayName("when GET /post")
    @Nested
    class getPostListTest{
        @BeforeEach
        void initEach() throws Exception {
            //given
            anyPostList = new ArrayList<>();
            anyPost = new Post(1L,"title","desc", LocalDate.now(), new Runner(1L),"aut");
            anyPost2 = new Post(2L,"title2","desc2", LocalDate.now(), new Runner(1L),"aut2");
            anyPostList.add(anyPost);
            anyPostList.add(anyPost2);
            anyPostListJson = objectMapper.writeValueAsString(anyPostList);
            Mockito.when(postService.getPosts())
                    .thenReturn(anyPostList);
            //when
            result = mvc.perform(MockMvcRequestBuilders.get("/post"));
        }
        @Test
        void shouldReturnOkWhenNoAuthentication() throws Exception {
            //then
            result.andExpect(MockMvcResultMatchers.status().isOk());
        }
        @Test
        void shouldReturnJson() throws Exception {
            //then
            result.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
        }
        @Test
        void shouldReturnList() throws Exception {
            //then
            result.andExpect(MockMvcResultMatchers.content().json(anyPostListJson));
        }
    }

    @DisplayName("when GET /post/{id}")
    @Nested
    class getPostTest{
        @BeforeEach
        void initEach() throws Exception {
            //given
            id = 1;
            anyPost = new Post(id,"title","desc", LocalDate.now(), new Runner(1L),"aut");
            anyPostJson = objectMapper.writeValueAsString(anyPost);
            Mockito.when(postService.getPost(id))
                    .thenReturn(anyPost);
            //when
            result = mvc.perform(MockMvcRequestBuilders.get("/post/{id}",id));
        }
        @Test
        void shouldReturnUnauthorizedWhenNotAuthorized() throws Exception {
            //then
            result.andExpect(MockMvcResultMatchers.status().isUnauthorized());
        }
        @Test
        @WithMockUser
        void shouldReturnOkWhenNotAuthorized() throws Exception {
            //then
            result.andExpect(MockMvcResultMatchers.status().isOk());
        }
        @Test
        @WithMockUser
        void shouldReturnJson() throws Exception {
            //then
            result.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
        }
        @Test
        @WithMockUser
        void shouldReturnPost() throws Exception {
            //then
            result.andExpect(MockMvcResultMatchers.content().json(anyPostJson));
        }
    }

    @DisplayName("when POST /post")
    @Nested
    class postPostTest{
        @BeforeEach
        void initEach() throws Exception {
            //given
            anyPost = new Post(1L ,"title","desc", LocalDate.of(2020,12,1), null,"aut");
            anyPostJson = objectMapper.writeValueAsString(anyPost);
            //when
            result = mvc.perform(MockMvcRequestBuilders.post("/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(anyPostJson));
        }
        @Test
        void shouldReturnUnauthorizedWhenNotAuthorized() throws Exception {
            //then
            result.andExpect(MockMvcResultMatchers.status().isUnauthorized());
        }
        @Test
        @WithMockUser
        void shouldReturnCreatedWhenAuthorized() throws Exception {
            //then
            result.andExpect(MockMvcResultMatchers.status().isCreated());
        }
        @Test
        @WithMockUser
        void shouldAddPost() throws Exception {
            //then
            Mockito.verify(postService).addPost(anyPost);
        }
        @Test
        @WithMockUser
        void shouldReturnEmpty() throws Exception {
            //then
            result.andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist());
        }
    }

    @DisplayName("when POST /post/runner/{id}")
    @Nested
    class postPostWithRunnerTest{
        @BeforeEach
        void initEach() throws Exception {
            //given
            id = 5;
            anyPost = new Post(1L,"title","desc", LocalDate.of(2020,12,1), null,"aut");
            anyPostJson = objectMapper.writeValueAsString(anyPost);
            //when
            result = mvc.perform(MockMvcRequestBuilders.post("/post/runner/{id}",id)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(anyPostJson));
        }
        @Test
        void shouldReturnUnauthorizedWhenNotAuthorized() throws Exception {
            //then
            result.andExpect(MockMvcResultMatchers.status().isUnauthorized());
        }
        @Test
        @WithMockUser
        void shouldReturnOkWhenAuthorized() throws Exception {
            //then
            result.andExpect(MockMvcResultMatchers.status().isCreated());
        }
        @Test
        @WithMockUser
        void shouldAddPost() throws Exception {
            //then
            Mockito.verify(postService).addPost(anyPost, id);
        }
        @Test
        @WithMockUser
        void shouldReturnEmpty() throws Exception {
            //then
            result.andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist());
        }
    }
}
