package cz.cvut.fel.groscdan.crmsystem.controller.mappers.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.PostStateDto;
import cz.cvut.fel.groscdan.crmsystem.model.channel.PostState;
import org.mapstruct.Mapper;

@Mapper
public interface PostStateMapper {
    PostState postStateDtoToPostState(PostStateDto postStateDto);

    PostStateDto postStateToPostStateDto(PostState postState);

}
