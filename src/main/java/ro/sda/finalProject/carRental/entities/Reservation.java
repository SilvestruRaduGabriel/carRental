package ro.sda.finalProject.carRental.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateOfBooking;
    private Customer client;
    private Car car;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String department;
    private int amount;

}
