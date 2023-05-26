package cz.cvut.fel.groscdan.crmsystem.controller.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.CommentDto;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.project.CommentMapper;
import cz.cvut.fel.groscdan.crmsystem.model.project.Comment;
import cz.cvut.fel.groscdan.crmsystem.service.project.CommentService;
import cz.cvut.fel.groscdan.crmsystem.service.project.TaskService;
import cz.cvut.fel.groscdan.crmsystem.util.UserToPersonMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;
    private final TaskService taskService;
    private final UserToPersonMapper userToPersonMapper;
    private final CommentMapper commentMapper = Mappers.getMapper(CommentMapper.class);

    public CommentController(CommentService commentService, TaskService taskService, UserToPersonMapper userToPersonMapper) {
        this.commentService = commentService;
        this.taskService = taskService;
        this.userToPersonMapper = userToPersonMapper;
    }

    @GetMapping
    public ResponseEntity<List<CommentDto>> getAll() {
        List<Comment> comments = commentService.getAll();
        return new ResponseEntity<>(commentMapper.commentToCommentDto(comments), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> get(@PathVariable Long id) {
        Comment comment = commentService.getOneById(id);
        CommentDto commentDto = commentMapper.commentToCommentDto(comment);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommentDto> create(@RequestBody CommentDto commentDto) {

        Comment comment = commentMapper.commentDtoToComment(commentDto);
        comment = commentService.create(comment);
        commentDto = commentMapper.commentToCommentDto(comment);
        return new ResponseEntity<>(commentDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CommentDto> update(@RequestBody CommentDto commentDto) {
        Comment comment = commentMapper.commentDtoToComment(commentDto);
        comment = commentService.update(comment);
        commentDto = commentMapper.commentToCommentDto(comment);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommentDto> delete(@PathVariable Long id) throws DeleteError {
        commentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

