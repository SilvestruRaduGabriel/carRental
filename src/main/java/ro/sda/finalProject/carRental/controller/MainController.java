package ro.sda.finalProject.carRental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

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
    public String contactPage() {
        return "contact";
    }

    @GetMapping("/faq")
    public String faqPage() {
        return "faq";
    }

    @GetMapping("/fleet")
    public String fleetPage() {
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
