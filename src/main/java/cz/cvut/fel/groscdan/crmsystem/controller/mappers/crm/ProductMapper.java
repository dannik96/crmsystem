package cz.cvut.fel.groscdan.crmsystem.controller.mappers.crm;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.crm.ProductDto;
import cz.cvut.fel.groscdan.crmsystem.model.crm.Product;
import org.mapstruct.*;

@Mapper
public interface ProductMapper {
    Product productDtoToProduct(ProductDto productDto);

    ProductDto productToProductDto(Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product updateProductFromProductDto(ProductDto productDto, @MappingTarget Product product);
}
