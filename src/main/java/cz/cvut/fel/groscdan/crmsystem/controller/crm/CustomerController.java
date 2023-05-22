package cz.cvut.fel.groscdan.crmsystem.controller.crm;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.crm.CustomerDto;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.project.CustomerMapper;
import cz.cvut.fel.groscdan.crmsystem.model.crm.Customer;
import cz.cvut.fel.groscdan.crmsystem.service.crm.CustomerService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll() {
        List<Customer> customers = customerService.getAll();
        return new ResponseEntity<>(customerMapper.customerToCustomerDto(customers), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> get(@PathVariable Long id) {
        Customer customer = customerService.getOneById(id);
        CustomerDto customerDto = customerMapper.customerToCustomerDto(customer);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> create(@RequestBody CustomerDto customerDto) {

        Customer customer = customerMapper.customerDtoToCustomer(customerDto);
        customer = customerService.create(customer);
        customerDto = customerMapper.customerToCustomerDto(customer);
        return new ResponseEntity<>(customerDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerDto) {
        Customer customer = customerMapper.customerDtoToCustomer(customerDto);
        customer = customerService.update(customer);
        customerDto = customerMapper.customerToCustomerDto(customer);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDto> delete(@PathVariable Long id) {
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

