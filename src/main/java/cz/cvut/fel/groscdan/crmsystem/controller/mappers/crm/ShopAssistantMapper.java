package cz.cvut.fel.groscdan.crmsystem.controller.mappers.crm;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.crm.ShopAssistantDto;
import cz.cvut.fel.groscdan.crmsystem.model.crm.ShopAssistant;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.Set;

@Mapper
public interface ShopAssistantMapper {
    ShopAssistant shopAssistantDtoToShopAssistant(ShopAssistantDto shopAssistantDto);

    ShopAssistantDto shopAssistantToShopAssistantDto(ShopAssistant shopAssistant);

    List<ShopAssistant> shopAssistantDtoToShopAssistant(List<ShopAssistantDto> shopAssistantDto);

    List<ShopAssistantDto> shopAssistantToShopAssistantDto(List<ShopAssistant> shopAssistant);

    Set<ShopAssistant> shopAssistantDtoToShopAssistant(Set<ShopAssistantDto> shopAssistantDto);

    Set<ShopAssistantDto> shopAssistantToShopAssistantDto(Set<ShopAssistant> shopAssistant);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ShopAssistant updateShopAssistantFromShopAssistantDto(ShopAssistantDto shopAssistantDto, @MappingTarget ShopAssistant shopAssistant);
}
