package cz.cvut.fel.groscdan.crmsystem.controller.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.PostStateDto;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.channel.PostStateMapper;
import cz.cvut.fel.groscdan.crmsystem.model.channel.PostState;
import cz.cvut.fel.groscdan.crmsystem.service.channel.PostStateService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/post-state")
public class PostStateController {
    private final PostStateService postStateService;
    private final PostStateMapper typeMapper = Mappers.getMapper(PostStateMapper.class);

    public PostStateController(PostStateService postStateService) {
        this.postStateService = postStateService;
    }

    @GetMapping
    public ResponseEntity<List<PostStateDto>> getAll(){
        List<PostState> types = postStateService.getAll();
        return new ResponseEntity<>(types.stream().map(typeMapper::postStateToPostStateDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostStateDto> get(@PathVariable Long id){
        PostState type = postStateService.getOneById(id);
        PostStateDto typeDto = typeMapper.postStateToPostStateDto(type);
        return new ResponseEntity<>(typeDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostStateDto> createType(@RequestBody PostStateDto typeDto) {

        PostState type = typeMapper.postStateDtoToPostState(typeDto);
        type = postStateService.create(type);
        typeDto = typeMapper.postStateToPostStateDto(type);
        return new ResponseEntity<>(typeDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PostStateDto> updateType(@RequestBody PostStateDto typeDto) {
        PostState type = typeMapper.postStateDtoToPostState(typeDto);
        type = postStateService.update(type);
        typeDto = typeMapper.postStateToPostStateDto(type);
        return new ResponseEntity<>(typeDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostStateDto> deleteType(@PathVariable Long id) throws DeleteError {
        postStateService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
