package team.back.mappers;

import org.mapstruct.Mapper;
import team.back.dto.PostDto;
import team.back.models.Post;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post map(PostDto postDto);
    PostDto map(Post post);
}
