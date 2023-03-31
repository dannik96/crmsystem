package cz.cvut.fel.groscdan.crmsystem.controller.mappers.crm;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.crm.ShopAssistantDto;
import cz.cvut.fel.groscdan.crmsystem.model.crm.ShopAssistant;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface ShopAssistantMapper {
    ShopAssistant shopAssistantDtoToShopAssistant(ShopAssistantDto shopAssistantDto);

    ShopAssistantDto shopAssistantToShopAssistantDto(ShopAssistant shopAssistant);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ShopAssistant updateShopAssistantFromShopAssistantDto(ShopAssistantDto shopAssistantDto, @MappingTarget ShopAssistant shopAssistant);
}
