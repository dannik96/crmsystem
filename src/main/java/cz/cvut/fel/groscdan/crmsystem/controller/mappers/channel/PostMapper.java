package cz.cvut.fel.groscdan.crmsystem.controller.mappers.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.ChannelDto;
import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.PostDto;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Channel;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Post;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface PostMapper {

    Post postDtoToPost(PostDto postDto);

    PostDto postToPostDto(Post post);



    Set<Post> postDtoToPost(Set<PostDto> postDto);

    Set<PostDto> postToPostDto(Set<Post> post);

}
