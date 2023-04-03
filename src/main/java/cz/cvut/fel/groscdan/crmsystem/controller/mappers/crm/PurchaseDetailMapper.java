package cz.cvut.fel.groscdan.crmsystem.controller.mappers.crm;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.crm.PurchaseDetailDto;
import cz.cvut.fel.groscdan.crmsystem.model.crm.PurchaseDetail;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.Set;

@Mapper
public interface PurchaseDetailMapper {
    PurchaseDetail purchaseDetailDtoToPurchaseDetail(PurchaseDetailDto purchaseDetailDto);

    PurchaseDetailDto purchaseDetailToPurchaseDetailDto(PurchaseDetail purchaseDetail);

    List<PurchaseDetail> purchaseDetailDtoToPurchaseDetail(List<PurchaseDetailDto> purchaseDetailDto);

    List<PurchaseDetailDto> purchaseDetailToPurchaseDetailDto(List<PurchaseDetail> purchaseDetail);

    Set<PurchaseDetail> purchaseDetailDtoToPurchaseDetail(Set<PurchaseDetailDto> purchaseDetailDto);

    Set<PurchaseDetailDto> purchaseDetailToPurchaseDetailDto(Set<PurchaseDetail> purchaseDetail);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PurchaseDetail updatePurchaseDetailFromPurchaseDetailDto(PurchaseDetailDto purchaseDetailDto, @MappingTarget PurchaseDetail purchaseDetail);
}
