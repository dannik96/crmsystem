package cz.cvut.fel.groscdan.crmsystem.controller.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.AudienceDto;
import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.ChannelTypeDto;
import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.TaskStateDto;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.channel.ChannelTypeMapper;
import cz.cvut.fel.groscdan.crmsystem.model.channel.ChannelType;
import cz.cvut.fel.groscdan.crmsystem.service.channel.ChannelTypeService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/channel-type")
public class ChannelTypeController {
    private final ChannelTypeService channelTypeService;
    private final ChannelTypeMapper channelTypeMapper = Mappers.getMapper(ChannelTypeMapper.class);

    public ChannelTypeController(ChannelTypeService channelTypeService) {
        this.channelTypeService = channelTypeService;
    }

    @GetMapping
    public ResponseEntity<List<ChannelTypeDto>> getAll() {
        List<ChannelType> channelTypes = channelTypeService.getAll();
        return new ResponseEntity<>(channelTypeMapper.channelTypeToChannelTypeDto(channelTypes), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ChannelTypeDto> updateType(@RequestBody ChannelTypeDto typeDto) {
        ChannelType channelType = channelTypeMapper.channelTypeDtoToChannelType(typeDto);
        channelType = channelTypeService.update(channelType);
        return new ResponseEntity<>(channelTypeMapper.channelTypeToChannelTypeDto(channelType), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskStateDto> delete(@PathVariable Long id) throws DeleteError {
        channelTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
