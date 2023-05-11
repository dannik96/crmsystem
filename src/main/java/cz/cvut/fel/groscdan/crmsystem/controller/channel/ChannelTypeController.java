package cz.cvut.fel.groscdan.crmsystem.controller.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.ChannelTypeDto;
import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.ProjectTypeDto;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.channel.ChannelTypeMapper;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.project.ProjectTypeMapper;
import cz.cvut.fel.groscdan.crmsystem.model.channel.ChannelType;
import cz.cvut.fel.groscdan.crmsystem.model.project.ProjectType;
import cz.cvut.fel.groscdan.crmsystem.service.channel.ChannelTypeService;
import cz.cvut.fel.groscdan.crmsystem.service.project.ProjectTypeService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/channel-type")
public class ChannelTypeController {
    private final ChannelTypeService channelTypeService;
    private final ChannelTypeMapper projectStateMapper = Mappers.getMapper(ChannelTypeMapper.class);

    public ChannelTypeController(ChannelTypeService channelTypeService) {
        this.channelTypeService = channelTypeService;
    }

    @GetMapping
    public ResponseEntity<List<ChannelTypeDto>> getAll() {
        List<ChannelType> channelTypes = channelTypeService.getAll();
        return new ResponseEntity<>(projectStateMapper.channelTypeToChannelTypeDto(channelTypes), HttpStatus.OK);
    }

}
