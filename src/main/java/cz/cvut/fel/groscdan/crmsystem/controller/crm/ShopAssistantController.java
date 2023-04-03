package cz.cvut.fel.groscdan.crmsystem.controller.crm;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.crm.ShopAssistantDto;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.crm.ShopAssistantMapper;
import cz.cvut.fel.groscdan.crmsystem.model.crm.ShopAssistant;
import cz.cvut.fel.groscdan.crmsystem.service.crm.ShopAssistantService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shop-assistant")
public class ShopAssistantController {

    private final ShopAssistantService shopAssistantService;
    private final ShopAssistantMapper shopAssistantMapper = Mappers.getMapper(ShopAssistantMapper.class);

    public ShopAssistantController(ShopAssistantService shopAssistantService) {
        this.shopAssistantService = shopAssistantService;
    }

    @GetMapping
    public ResponseEntity<List<ShopAssistantDto>> getAll() {
        List<ShopAssistant> shopAssistants = shopAssistantService.getAll();
        return new ResponseEntity<>(shopAssistantMapper.shopAssistantToShopAssistantDto(shopAssistants), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopAssistantDto> get(@PathVariable Long id) {
        ShopAssistant shopAssistant = shopAssistantService.getOneById(id);
        ShopAssistantDto shopAssistantDto = shopAssistantMapper.shopAssistantToShopAssistantDto(shopAssistant);
        return new ResponseEntity<>(shopAssistantDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ShopAssistantDto> create(@RequestBody ShopAssistantDto shopAssistantDto) {

        ShopAssistant shopAssistant = shopAssistantMapper.shopAssistantDtoToShopAssistant(shopAssistantDto);
        shopAssistant = shopAssistantService.create(shopAssistant);
        shopAssistantDto = shopAssistantMapper.shopAssistantToShopAssistantDto(shopAssistant);
        return new ResponseEntity<>(shopAssistantDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ShopAssistantDto> update(@RequestBody ShopAssistantDto shopAssistantDto) {
        ShopAssistant shopAssistant = shopAssistantMapper.shopAssistantDtoToShopAssistant(shopAssistantDto);
        shopAssistant = shopAssistantService.update(shopAssistant);
        shopAssistantDto = shopAssistantMapper.shopAssistantToShopAssistantDto(shopAssistant);
        return new ResponseEntity<>(shopAssistantDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ShopAssistantDto> delete(@PathVariable Long id) {
        shopAssistantService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

