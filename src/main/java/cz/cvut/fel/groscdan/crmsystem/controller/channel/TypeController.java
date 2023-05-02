package cz.cvut.fel.groscdan.crmsystem.controller.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.TypeDto;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.channel.TypeMapper;
import cz.cvut.fel.groscdan.crmsystem.model.channel.ChannelType;
import cz.cvut.fel.groscdan.crmsystem.service.channel.ChannelTypeService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/type")
public class TypeController {

    private final ChannelTypeService channelTypeService;
    private final TypeMapper typeMapper = Mappers.getMapper(TypeMapper.class);

    public TypeController(ChannelTypeService channelTypeService) {
        this.channelTypeService = channelTypeService;
    }

    @GetMapping
    public ResponseEntity<List<TypeDto>> getAll() {
        List<ChannelType> channelTypes = channelTypeService.getAll();
        return new ResponseEntity<>(channelTypes.stream().map(typeMapper::typeToTypeDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeDto> get(@PathVariable Long id) {
        ChannelType channelType = channelTypeService.getOneById(id);
        TypeDto typeDto = typeMapper.typeToTypeDTO(channelType);
        return new ResponseEntity<>(typeDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TypeDto> createType(@RequestBody TypeDto typeDto) {

        ChannelType channelType = typeMapper.typeDTOtoType(typeDto);
        channelType = channelTypeService.create(channelType);
        typeDto = typeMapper.typeToTypeDTO(channelType);
        return new ResponseEntity<>(typeDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TypeDto> updateType(@RequestBody TypeDto typeDto) {
        ChannelType channelType = typeMapper.typeDTOtoType(typeDto);
        channelType = channelTypeService.update(channelType);
        typeDto = typeMapper.typeToTypeDTO(channelType);
        return new ResponseEntity<>(typeDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TypeDto> deleteType(@PathVariable Long id) throws DeleteError {
        channelTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
