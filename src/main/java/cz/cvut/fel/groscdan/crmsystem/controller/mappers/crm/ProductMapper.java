package cz.cvut.fel.groscdan.crmsystem.controller.mappers.crm;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.crm.ProductDto;
import cz.cvut.fel.groscdan.crmsystem.model.crm.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.Set;

@Mapper
public interface ProductMapper {
    Product productDtoToProduct(ProductDto productDto);

    ProductDto productToProductDto(Product product);

    List<Product> productDtoToProduct(List<ProductDto> productDto);

    List<ProductDto> productToProductDto(List<Product> product);

    Set<Product> productDtoToProduct(Set<ProductDto> productDto);

    Set<ProductDto> productToProductDto(Set<Product> product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product updateProductFromProductDto(ProductDto productDto, @MappingTarget Product product);
}
