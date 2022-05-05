package ro.sda.finalProject.carRental.entities;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import ro.sda.finalProject.carRental.model.Status;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    private String bodyType;

    private int year;

    private String colour;

    private int mileage;

    private Status status;

    private int amount;

    @Lob
    private String image;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @OneToMany(mappedBy = "car")
    private List<Reservation> reservations;
}
