package cz.cvut.fel.groscdan.crmsystem.controller.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.ChannelDto;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.channel.AudienceMapper;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.channel.ChannelMapper;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.channel.PostMapper;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.channel.TypeMapper;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Audience;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Channel;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Post;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Type;
import cz.cvut.fel.groscdan.crmsystem.service.channel.ChannelService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/channel")
public class ChannelController {

    private final ChannelService channelService;
    private final ChannelMapper channelMapper = Mappers.getMapper(ChannelMapper.class);
    private final PostMapper postMapper = Mappers.getMapper(PostMapper.class);
    private final AudienceMapper audienceMapper = Mappers.getMapper(AudienceMapper.class);
    private final TypeMapper typeMapper = Mappers.getMapper(TypeMapper.class);

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping
    public ResponseEntity<List<ChannelDto>> getAll() {
        List<Channel> types = channelService.getAll();
        return new ResponseEntity<>(types.stream().map(channelMapper::channelToChannelDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChannelDto> get(@PathVariable Long id) {
        Channel type = channelService.getOneById(id);
        ChannelDto typeDto = channelMapper.channelToChannelDto(type);
        return new ResponseEntity<>(typeDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ChannelDto> createChannel(@RequestBody ChannelDto typeDto) {

        Channel type = channelMapper.channelDtoToChannel(typeDto);
        type = channelService.create(type);
        typeDto = channelMapper.channelToChannelDto(type);
        return new ResponseEntity<>(typeDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ChannelDto> updateChannel(@RequestBody ChannelDto typeDto) {
        Channel type = channelMapper.channelDtoToChannel(typeDto);
        type = channelService.update(type);
        typeDto = channelMapper.channelToChannelDto(type);
        return new ResponseEntity<>(typeDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ChannelDto> deleteChannel(@PathVariable Long id) throws DeleteError {
        channelService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PatchMapping("/{channelId}/add-type/{typeId}")
    public ResponseEntity<?> addChannelType(@PathVariable Long channelId, @PathVariable Long typeId) {
        channelService.addType(channelId, typeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{channelId}/remove-type/{typeId}")
    public ResponseEntity<?> removeChannelType(@PathVariable Long channelId, @PathVariable Long typeId) {
        channelService.removeType(channelId, typeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{channelId}/add-audience/{audienceId}")
    public ResponseEntity<?> addChannelAudience(@PathVariable Long channelId, @PathVariable Long audienceId) {
        channelService.addAudience(channelId, audienceId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{channelId}/remove-audience/{audienceId}")
    public ResponseEntity<?> removeChannelAudience(@PathVariable Long channelId, @PathVariable Long audienceId) {
        channelService.removeAudience(channelId, audienceId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<?> getChannelPosts(@PathVariable Long id) {
        Set<Post> posts = channelService.getAllPosts(id);
        return new ResponseEntity<>(postMapper.postToPostDto(posts), HttpStatus.OK);
    }

    @GetMapping("/{id}/audiences")
    public ResponseEntity<?> getChannelAudiences(@PathVariable Long id) {
        Set<Audience> audiences = channelService.getAllAudiences(id);
        return new ResponseEntity<>(audienceMapper.audienceToAudienceDto(audiences), HttpStatus.OK);
    }

    @GetMapping("/{id}/types")
    public ResponseEntity<?> getChannelTypes(@PathVariable Long id) {
        Set<Type> types = channelService.getAllTypes(id);
        return new ResponseEntity<>(typeMapper.typeToTypeDto(types), HttpStatus.OK);
    }
}
