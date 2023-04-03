package cz.cvut.fel.groscdan.crmsystem.controller.crm;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.crm.PurchaseDto;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.crm.PurchaseMapper;
import cz.cvut.fel.groscdan.crmsystem.model.crm.Purchase;
import cz.cvut.fel.groscdan.crmsystem.service.crm.PurchaseService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;
    private final PurchaseMapper purchaseMapper = Mappers.getMapper(PurchaseMapper.class);

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public ResponseEntity<List<PurchaseDto>> getAll() {
        List<Purchase> purchases = purchaseService.getAll();
        return new ResponseEntity<>(purchaseMapper.purchaseToPurchaseDto(purchases), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseDto> get(@PathVariable Long id) {
        Purchase purchase = purchaseService.getOneById(id);
        PurchaseDto purchaseDto = purchaseMapper.purchaseToPurchaseDto(purchase);
        return new ResponseEntity<>(purchaseDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PurchaseDto> create(@RequestBody PurchaseDto purchaseDto) {

        Purchase purchase = purchaseMapper.purchaseDtoToPurchase(purchaseDto);
        purchase = purchaseService.create(purchase);
        purchaseDto = purchaseMapper.purchaseToPurchaseDto(purchase);
        return new ResponseEntity<>(purchaseDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PurchaseDto> update(@RequestBody PurchaseDto purchaseDto) {
        Purchase purchase = purchaseMapper.purchaseDtoToPurchase(purchaseDto);
        purchase = purchaseService.update(purchase);
        purchaseDto = purchaseMapper.purchaseToPurchaseDto(purchase);
        return new ResponseEntity<>(purchaseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PurchaseDto> delete(@PathVariable Long id) {
        purchaseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

