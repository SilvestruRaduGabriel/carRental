package ro.sda.finalProject.carRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String showAllCustomers(Model model){
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customersList",customers);
     return "customerList";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("customerForm", new CustomerForm());
        return "customer";
    }

    @PostMapping("/")
    public String createCustomer(@ModelAttribute("customerForm") @Valid CustomerForm customerForm, Model model) {
        //TODO define method in service for creating a customer
        return "redirect:/customer/";

    }
}
