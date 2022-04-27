package ro.sda.finalProject.carRental.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateOfBooking;
    @OneToOne()
    private Customer client;
    @OneToOne()
    private Car car;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String department;
    private int amount;
    //test

}
