package cz.cvut.fel.groscdan.crmsystem.controller.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.AudienceDto;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.channel.AudienceMapper;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Audience;
import cz.cvut.fel.groscdan.crmsystem.service.channel.AudienceService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/audience")
public class AudienceController {
    private final AudienceService audienceService;
    private final AudienceMapper audienceMapper = Mappers.getMapper(AudienceMapper.class);

    public AudienceController(AudienceService audienceService) {
        this.audienceService = audienceService;
    }

    @GetMapping
    public ResponseEntity<List<AudienceDto>> getAll(){
        List<Audience> audiences = audienceService.getAll();
        return new ResponseEntity<>(audienceMapper.audienceToAudienceDto(audiences), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AudienceDto> get(@PathVariable Long id){
        Audience audience = audienceService.getOneById(id);
        AudienceDto audienceDto = audienceMapper.audienceToAudienceDto(audience);
        return new ResponseEntity<>(audienceDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AudienceDto> createType(@RequestBody AudienceDto typeDto) {

        Audience audience = audienceMapper.audienceDtoToAudience(typeDto);
        audience = audienceService.create(audience);
        typeDto = audienceMapper.audienceToAudienceDto(audience);
        return new ResponseEntity<>(typeDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AudienceDto> updateType(@RequestBody AudienceDto typeDto) {
        Audience audience = audienceMapper.audienceDtoToAudience(typeDto);
        audience = audienceService.update(audience);
        typeDto = audienceMapper.audienceToAudienceDto(audience);
        return new ResponseEntity<>(typeDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AudienceDto> deleteType(@PathVariable Long id) throws DeleteError {
        audienceService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
