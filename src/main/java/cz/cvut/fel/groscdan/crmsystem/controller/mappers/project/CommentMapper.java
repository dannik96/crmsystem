package cz.cvut.fel.groscdan.crmsystem.controller.mappers.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.CommentDto;
import cz.cvut.fel.groscdan.crmsystem.model.project.Comment;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper
public interface CommentMapper {
    Comment commentDtoToComment(CommentDto commentDto);

    CommentDto commentToCommentDto(Comment comment);

    List<Comment> commentDtoToComment(List<CommentDto> commentDto);

    List<CommentDto> commentToCommentDto(List<Comment> comment);
}
