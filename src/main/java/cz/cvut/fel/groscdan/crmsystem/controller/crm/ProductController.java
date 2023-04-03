package cz.cvut.fel.groscdan.crmsystem.controller.crm;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.crm.ProductDto;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.crm.ProductMapper;
import cz.cvut.fel.groscdan.crmsystem.model.crm.Product;
import cz.cvut.fel.groscdan.crmsystem.service.crm.ProductService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll() {
        List<Product> products = productService.getAll();
        return new ResponseEntity<>(productMapper.productToProductDto(products), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> get(@PathVariable Long id) {
        Product product = productService.getOneById(id);
        ProductDto productDto = productMapper.productToProductDto(product);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto) {

        Product product = productMapper.productDtoToProduct(productDto);
        product = productService.create(product);
        productDto = productMapper.productToProductDto(product);
        return new ResponseEntity<>(productDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto) {
        Product product = productMapper.productDtoToProduct(productDto);
        product = productService.update(product);
        productDto = productMapper.productToProductDto(product);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDto> delete(@PathVariable Long id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

