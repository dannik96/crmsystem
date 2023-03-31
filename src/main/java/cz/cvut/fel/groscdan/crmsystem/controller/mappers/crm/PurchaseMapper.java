package cz.cvut.fel.groscdan.crmsystem.controller.mappers.crm;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.crm.PurchaseDto;
import cz.cvut.fel.groscdan.crmsystem.model.crm.Purchase;
import org.mapstruct.*;

@Mapper
public interface PurchaseMapper {
    Purchase purchaseDtoToPurchase(PurchaseDto purchaseDto);

    PurchaseDto purchaseToPurchaseDto(Purchase purchase);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Purchase updatePurchaseFromPurchaseDto(PurchaseDto purchaseDto, @MappingTarget Purchase purchase);
}
