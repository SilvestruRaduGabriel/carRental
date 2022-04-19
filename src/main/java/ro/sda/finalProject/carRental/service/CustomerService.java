package ro.sda.finalProject.carRental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import ro.sda.finalProject.carRental.entities.Customer;
import ro.sda.finalProject.carRental.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
