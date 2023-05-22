package cz.cvut.fel.groscdan.crmsystem.controller.mappers.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.crm.CustomerDto;
import cz.cvut.fel.groscdan.crmsystem.model.crm.Customer;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.Set;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDto customerDto);

    CustomerDto customerToCustomerDto(Customer customer);

    List<Customer> customerDtoToCustomer(List<CustomerDto> customerDto);

    List<CustomerDto> customerToCustomerDto(List<Customer> customer);

    Set<Customer> customerDtoToCustomer(Set<CustomerDto> customerDto);

    Set<CustomerDto> customerToCustomerDto(Set<Customer> customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer updateCustomerFromCustomerDto(CustomerDto customerDto, @MappingTarget Customer customer);
}
