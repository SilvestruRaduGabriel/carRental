package ro.sda.finalProject.carRental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.finalProject.carRental.entities.Customer;
import ro.sda.finalProject.carRental.exceptions.CustomerNotFundError;
import ro.sda.finalProject.carRental.mappers.CustomerMapper;
import ro.sda.finalProject.carRental.model.CustomerForm;
import ro.sda.finalProject.carRental.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

  //  public void createCustomer(CustomerForm form) {
   //     Customer customer = new Customer();
   //     customer.setFirstName(form.getFirstName());
  //      customer.setFirstName(form.getLastName());
  //      customer.setFirstName(form.getEmail());
 //       customer.setFirstName(form.getAddress());

 //   }

    public void createCustomer(CustomerForm form) {
        Customer customer= customerMapper.convertToEntity(form);
       customerRepository.save(customer);
    }

    public CustomerForm findById(Integer id) {
        Customer entityCustomer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFundError(String.format("Customer with %s is not on the list.", id)));
        return customerMapper.convertToDto(entityCustomer);
    }

    public void deleteById(Integer id) {
        customerRepository.findById(id).orElseThrow(() -> new CustomerNotFundError(String.format("Customer with %s is not on the list.", id)));
        customerRepository.deleteById(id);
    }
}


