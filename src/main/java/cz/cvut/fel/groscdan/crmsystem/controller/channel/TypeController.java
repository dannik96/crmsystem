package cz.cvut.fel.groscdan.crmsystem.controller.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.TypeDto;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.channel.TypeMapper;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Type;
import cz.cvut.fel.groscdan.crmsystem.service.channel.TypeService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/type")
public class TypeController {

    private final TypeService typeService;
    private final TypeMapper typeMapper = Mappers.getMapper(TypeMapper.class);

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping
    public ResponseEntity<List<TypeDto>> getAll() {
        List<Type> types = typeService.getAll();
        return new ResponseEntity<>(types.stream().map(typeMapper::typeToTypeDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeDto> get(@PathVariable Long id) {
        Type type = typeService.getOneById(id);
        TypeDto typeDto = typeMapper.typeToTypeDTO(type);
        return new ResponseEntity<>(typeDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TypeDto> createType(@RequestBody TypeDto typeDto) {

        Type type = typeMapper.typeDTOtoType(typeDto);
        type = typeService.create(type);
        typeDto = typeMapper.typeToTypeDTO(type);
        return new ResponseEntity<>(typeDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TypeDto> updateType(@RequestBody TypeDto typeDto) {
        Type type = typeMapper.typeDTOtoType(typeDto);
        type = typeService.update(type);
        typeDto = typeMapper.typeToTypeDTO(type);
        return new ResponseEntity<>(typeDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TypeDto> deleteType(@PathVariable Long id) throws DeleteError {
        typeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
