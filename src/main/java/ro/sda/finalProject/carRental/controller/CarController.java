package ro.sda.finalProject.carRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.sda.finalProject.carRental.entities.Car;
import ro.sda.finalProject.carRental.model.CarForm;
import ro.sda.finalProject.carRental.service.CarService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public String showAllCars(Model model) {
        List<Car> cars = carService.findAll();
        model.addAttribute("carList", cars);
        return "carList";
    }

    @GetMapping("/create")
    public String showCarForm(Model model) {
        model.addAttribute("carForm", new CarForm());
        return "car_create";
    }

    @PostMapping(value = "/create")
    public String createCar(@RequestParam("file") MultipartFile photo, @ModelAttribute("carForm") @Valid CarForm carForm, Model model, Errors errors) {
        if (errors.hasErrors()) {
            return "car_create";
        } else {
            if (!photo.isEmpty()) {
                try {
                    String fileBytes = Base64.getMimeEncoder().encodeToString(photo.getBytes());
                    carForm.setImage(fileBytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        carService.create(carForm);
        return "redirect:/cars/";
    }

    @GetMapping("/edit/{carId}")
    public String showEditForm(@PathVariable("carId") Long id, Model model) {
        Car carForm = carService.findById(id);
        model.addAttribute("carForm", carForm);
        return "car_create";
    }

    @GetMapping("/delete/{carId}")
    public String deleteCar(@PathVariable("carId") Long id, Model model) {
        carService.delete(id);
        return "redirect:/cars/";
    }

}
