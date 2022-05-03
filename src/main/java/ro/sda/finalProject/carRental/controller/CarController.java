package ro.sda.finalProject.carRental.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.finalProject.carRental.entities.Car;
import ro.sda.finalProject.carRental.entities.Customer;
import ro.sda.finalProject.carRental.service.CarService;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String showAllCars(Model model) {
        List<Car> cars = carService.findAll();
        model.addAttribute("carList", cars);
        return "carList";
    }
}
