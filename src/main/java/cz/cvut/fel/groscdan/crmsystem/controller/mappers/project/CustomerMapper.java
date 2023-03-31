package cz.cvut.fel.groscdan.crmsystem.controller.mappers.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.CustomerDto;
import cz.cvut.fel.groscdan.crmsystem.model.crm.Customer;
import org.mapstruct.*;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDto customerDto);

    CustomerDto customerToCustomerDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer updateCustomerFromCustomerDto(CustomerDto customerDto, @MappingTarget Customer customer);
}
