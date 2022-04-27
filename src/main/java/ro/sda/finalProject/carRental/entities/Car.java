package ro.sda.finalProject.carRental.entities;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import ro.sda.finalProject.carRental.model.Status;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    private String bodyType;

    private LocalDate year;

    private String colour;

    private int mileage;

    private Status status;

    private int amount;
}
