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

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer client;

    @ManyToOne(fetch = FetchType.LAZY)
    private Car car;

    private LocalDate dateFrom;
    private LocalDate dateTo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Branch returnBranch;

    @ManyToOne(fetch = FetchType.LAZY)
    private Branch loanBranch;

    private int amount;
    //test

}
