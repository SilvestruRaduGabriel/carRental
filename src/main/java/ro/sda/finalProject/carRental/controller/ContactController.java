package ro.sda.finalProject.carRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.sda.finalProject.carRental.model.ContactForm;
import ro.sda.finalProject.carRental.service.EmailService;

import javax.validation.Valid;

@Controller
@RequestMapping("/contactToEmail")
public class ContactController {

    @Autowired
    private EmailService emailService;


    @PostMapping("/createMessage")
    public String createEMail(@ModelAttribute("contactForm") @Valid ContactForm contactForm, Model model) {
        emailService.sendEmail(contactForm.getName(), contactForm.getEmail(), contactForm.getSubject(), contactForm.getNotes());
        return "redirect:/contact/";
    }

}
