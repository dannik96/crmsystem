package cz.cvut.fel.groscdan.crmsystem.controller.mappers.crm;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.crm.PurchaseDetailDto;
import cz.cvut.fel.groscdan.crmsystem.model.crm.PurchaseDetail;
import org.mapstruct.*;

@Mapper
public interface PurchaseDetailMapper {
    PurchaseDetail purchaseDetailDtoToPurchaseDetail(PurchaseDetailDto purchaseDetailDto);

    PurchaseDetailDto purchaseDetailToPurchaseDetailDto(PurchaseDetail purchaseDetail);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PurchaseDetail updatePurchaseDetailFromPurchaseDetailDto(PurchaseDetailDto purchaseDetailDto, @MappingTarget PurchaseDetail purchaseDetail);
}
