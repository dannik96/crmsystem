package cz.cvut.fel.groscdan.crmsystem.controller.mappers.crm;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.crm.PurchaseDto;
import cz.cvut.fel.groscdan.crmsystem.model.crm.Purchase;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.Set;

@Mapper
public interface PurchaseMapper {
    Purchase purchaseDtoToPurchase(PurchaseDto purchaseDto);

    PurchaseDto purchaseToPurchaseDto(Purchase purchase);

    List<Purchase> purchaseDtoToPurchase(List<PurchaseDto> purchaseDto);

    List<PurchaseDto> purchaseToPurchaseDto(List<Purchase> purchase);

    Set<Purchase> purchaseDtoToPurchase(Set<PurchaseDto> purchaseDto);

    Set<PurchaseDto> purchaseToPurchaseDto(Set<Purchase> purchase);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Purchase updatePurchaseFromPurchaseDto(PurchaseDto purchaseDto, @MappingTarget Purchase purchase);
}
