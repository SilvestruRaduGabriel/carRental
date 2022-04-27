package ro.sda.finalProject.carRental.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.finalProject.carRental.entities.Customer;
import ro.sda.finalProject.carRental.model.CustomerForm;
import ro.sda.finalProject.carRental.repository.CustomerRepository;
@Service
public class CustomerMapper implements Mapper<Customer, CustomerForm> {


   @Autowired
   private CustomerRepository customerRepository;

    @Override
    public CustomerForm convertToDto(Customer entity) {

        CustomerForm customerForm = new CustomerForm();
        customerForm.setCustomerId(entity.getId());
        customerForm.setFirstName(entity.getFirstName());
        customerForm.setLastName(entity.getLastName());
        customerForm.setEmail(entity.getEmail());
        customerForm.setAddress(entity.getAddress());
        return customerForm;

    }

    @Override
    public Customer convertToEntity(CustomerForm dto) {
        Customer customer;
        if (dto.getCustomerId() != null) {
           customer = customerRepository.findById(dto.getCustomerId()).orElse(new Customer());
        } else {
            customer = new Customer();
        }
        customer.setId(dto.getCustomerId());
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setAddress(dto.getAddress());
        return customer;
    }


}
