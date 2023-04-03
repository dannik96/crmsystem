package cz.cvut.fel.groscdan.crmsystem.controller.crm;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.crm.PurchaseDetailDto;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.crm.PurchaseDetailMapper;
import cz.cvut.fel.groscdan.crmsystem.model.crm.PurchaseDetail;
import cz.cvut.fel.groscdan.crmsystem.service.crm.PurchaseDetailService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-detail")
public class PurchaseDetailController {

    private final PurchaseDetailService purchaseDetailService;
    private final PurchaseDetailMapper purchaseDetailMapper = Mappers.getMapper(PurchaseDetailMapper.class);

    public PurchaseDetailController(PurchaseDetailService purchaseDetailService) {
        this.purchaseDetailService = purchaseDetailService;
    }

    @GetMapping
    public ResponseEntity<List<PurchaseDetailDto>> getAll() {
        List<PurchaseDetail> purchaseDetails = purchaseDetailService.getAll();
        return new ResponseEntity<>(purchaseDetailMapper.purchaseDetailToPurchaseDetailDto(purchaseDetails), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseDetailDto> get(@PathVariable Long id) {
        PurchaseDetail purchaseDetail = purchaseDetailService.getOneById(id);
        PurchaseDetailDto purchaseDetailDto = purchaseDetailMapper.purchaseDetailToPurchaseDetailDto(purchaseDetail);
        return new ResponseEntity<>(purchaseDetailDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PurchaseDetailDto> create(@RequestBody PurchaseDetailDto purchaseDetailDto) {

        PurchaseDetail purchaseDetail = purchaseDetailMapper.purchaseDetailDtoToPurchaseDetail(purchaseDetailDto);
        purchaseDetail = purchaseDetailService.create(purchaseDetail);
        purchaseDetailDto = purchaseDetailMapper.purchaseDetailToPurchaseDetailDto(purchaseDetail);
        return new ResponseEntity<>(purchaseDetailDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PurchaseDetailDto> update(@RequestBody PurchaseDetailDto purchaseDetailDto) {
        PurchaseDetail purchaseDetail = purchaseDetailMapper.purchaseDetailDtoToPurchaseDetail(purchaseDetailDto);
        purchaseDetail = purchaseDetailService.update(purchaseDetail);
        purchaseDetailDto = purchaseDetailMapper.purchaseDetailToPurchaseDetailDto(purchaseDetail);
        return new ResponseEntity<>(purchaseDetailDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PurchaseDetailDto> delete(@PathVariable Long id) {
        purchaseDetailService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

