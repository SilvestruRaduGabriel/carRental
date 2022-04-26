package ro.sda.finalProject.carRental.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.sda.finalProject.carRental.entities.Reservation;
import ro.sda.finalProject.carRental.service.ReservationService;

import java.util.List;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @GetMapping("/")
    public void showAllReservation(Model model){
        List<Reservation> reservations = reservationService.getAllReservations();
       // model.addAllAttributes("reservationsList", reservations);
    }
}
