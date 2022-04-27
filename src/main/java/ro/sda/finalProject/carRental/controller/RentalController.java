package ro.sda.finalProject.carRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.sda.finalProject.carRental.entities.Rental;
import ro.sda.finalProject.carRental.model.RentalForm;
import ro.sda.finalProject.carRental.service.RentalService;

import javax.mail.Multipart;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @GetMapping("/")
    public String showAllRentals(Model model) {
        List<Rental> rentals = rentalService.findAllRentals();
        model.addAttribute("rentalList", rentals);
        return "rentalList";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("rentalForm", new RentalForm());
        return "rental_create";
    }

    @PostMapping(value = "/create", consumes = {"multipart/form-data"})
    public String createRental(@ModelAttribute("rentalForm") @Valid RentalForm form, Errors errors, Model model,
                               BindingResult bindingResult, @RequestParam("photo") MultipartFile photo) {
        if (bindingResult.hasErrors()) {
            return "errorPage";
        } else {
            if (!photo.isEmpty()) {
                try {
                    byte[] fileBytes = photo.getBytes();
                    form.setLogoType(fileBytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (errors.hasErrors()) {
            return "rental_create";
        }
        rentalService.createRental(form);
        return "redirect:/rentalList";
    }

    @GetMapping("/edit/{rentalId}")
    public String showEditForm(@PathVariable("rentalId") int id, Model model) {
        RentalForm rentalForm = rentalService.findById(id);
        model.addAttribute("rentalForm", rentalForm);
        return "rental_create";
    }

    @GetMapping("/delete/{rentalId}")
    public String deleteRental(@PathVariable("rentalId") int id, Model model) {
        rentalService.deleteById(id);
        return "redirect:/rentalList";
    }


}
