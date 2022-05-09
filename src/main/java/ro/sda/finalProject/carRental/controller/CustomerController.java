package ro.sda.finalProject.carRental.controller;// pCackage ro.sda.finalProject.carRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sda.finalProject.carRental.entities.Customer;
import ro.sda.finalProject.carRental.model.CustomerForm;
import ro.sda.finalProject.carRental.service.CustomerService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String showAllCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customerList", customers);
        return "customerList";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("customerForm", new CustomerForm());
        return "customer_create";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute("customerForm") @Valid CustomerForm customerForm, Model model) {
        customerService.createCustomer(customerForm);
        return "redirect:/customer/";

    }

    @GetMapping("/edit/{customerId}")
    public String showEditForm(@PathVariable("customerId") Integer id, Model model) {
        CustomerForm customerForm = customerService.findById(id);
        model.addAttribute("customerForm", customerForm);
        return "customer_create";
    }

    @GetMapping("/delete/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") Integer id, Model model) {
        customerService.deleteById(id);
        return "redirect:/customer/";
    }


//    @Autowired
//    public void setCustomerService(CustomerService customerService) {
//        this.customerService = customerService;
//    }
}


