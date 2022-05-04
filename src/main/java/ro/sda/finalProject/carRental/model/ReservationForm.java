package ro.sda.finalProject.carRental.model;

import com.sun.istack.NotNull;
import lombok.Data;
import ro.sda.finalProject.carRental.entities.Car;
import ro.sda.finalProject.carRental.entities.Customer;

import java.time.LocalDate;

@Data
public class ReservationForm {
    private Long id;
    @NotNull
    private LocalDate dateOfBooking;
    @NotNull
    private Customer client;
    @NotNull
    private Car car;
    @NotNull
    private LocalDate dateFrom;
    @NotNull
    private LocalDate dateTo;
    @NotNull
    private String department;
    @NotNull
    private int amount;

}
