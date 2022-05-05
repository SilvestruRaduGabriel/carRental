package ro.sda.finalProject.carRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ro.sda.finalProject.carRental.entities.Car;
import ro.sda.finalProject.carRental.service.CarService;

import java.util.List;
import ro.sda.finalProject.carRental.model.ContactForm;


@Controller
public class MainController {

    @Autowired
    private CarService carService;

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/blog")
    public String blogPage() {
        return "blog";
    }

    @GetMapping("/blog-post")
    public String blogPostPage() {
        return "blog-post";
    }

    @GetMapping("/contact")
    public String contactPage(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    @GetMapping("/faq")
    public String faqPage() {
        return "faq";
    }

    @GetMapping("/fleet")
    public String fleetPage(Model model) {
        List<Car> cars = carService.findAll();
        model.addAttribute("carList", cars);
        return "fleet";
    }

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/offers")
    public String offersPage() {
        return "offers";
    }

    @GetMapping("/team")
    public String teamPage() {
        return "team";
    }

    @GetMapping("/terms")
    public String termsPage() {
        return "terms";
    }

    @GetMapping("/testimonials")
    public String testimonialsPage() {
        return "testimonials";
    }
}
