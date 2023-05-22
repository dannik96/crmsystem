package cz.cvut.fel.groscdan.crmsystem.controller.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.PostDto;
import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.TaskDto;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.PatchError;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.channel.PostMapper;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.project.TaskMapper;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Post;
import cz.cvut.fel.groscdan.crmsystem.model.project.Task;
import cz.cvut.fel.groscdan.crmsystem.service.channel.PostService;
import cz.cvut.fel.groscdan.crmsystem.service.project.TaskService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/post")
public class PostController {
    
    private final PostService postService;
    private final TaskService taskService;
    private final PostMapper postMapper = Mappers.getMapper(PostMapper.class);
    private final TaskMapper taskMapper = Mappers.getMapper(TaskMapper.class);

    public PostController(PostService postService, TaskService taskService) {
        this.postService = postService;
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAll(){
        List<Post> posts = postService.getAll();
        return new ResponseEntity<>(posts.stream().map(postMapper::postToPostDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> get(@PathVariable Long id){
        Post post = postService.getOneById(id);
        return new ResponseEntity<>(postMapper.postToPostDto(post), HttpStatus.OK);
    }

    @GetMapping("/{id}/assignable-tasks")
    public ResponseEntity<List<TaskDto>> getAssignableTasks(@PathVariable Long id){
        List<Task> tasks = taskService.getAssignableTasks(id);
        return new ResponseEntity<>(taskMapper.taskToTaskDto(tasks), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto typeDto) {

        Post post = postMapper.postDtoToPost(typeDto);
        post = postService.create(post);
        return new ResponseEntity<>(postMapper.postToPostDto(post), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto typeDto) {
        Post post = postMapper.postDtoToPost(typeDto);
        post = postService.update(post);
        return new ResponseEntity<>(postMapper.postToPostDto(post), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostDto> deletePost(@PathVariable Long id) throws DeleteError {
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{postId}/set-state/{stateId}")
    public ResponseEntity<PostDto> setState(@PathVariable Long postId, @PathVariable Long stateId) throws PatchError {
        postService.setState(postId, stateId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{postId}/add-channel/{channelId}")
    public ResponseEntity<PostDto> addChannel(@PathVariable Long postId, @PathVariable Long channelId) throws PatchError {
        postService.addChannel(postId, channelId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{postId}/remove-channel/{channelId}")
    public ResponseEntity<PostDto> removeChannel(@PathVariable Long postId, @PathVariable Long channelId) throws PatchError {
        postService.removeChannel(postId, channelId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
