package cz.cvut.fel.groscdan.crmsystem.controller.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.ChannelDto;
import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.PostDto;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.channel.PostMapper;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Post;
import cz.cvut.fel.groscdan.crmsystem.service.channel.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/post")
public class PostController {
    
    private final PostService postService;
    private final PostMapper postMapper;

    public PostController(PostService postService, PostMapper postMapper) {
        this.postService = postService;
        this.postMapper = postMapper;
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
    public ResponseEntity<ChannelDto> deletePost(@PathVariable Long id) throws DeleteError {
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{postId}/set-state/{stateId}}")
    public ResponseEntity<ChannelDto> setState(@PathVariable Long postId, @PathVariable Long stateId) throws DeleteError {
        postService.setState(postId, stateId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
