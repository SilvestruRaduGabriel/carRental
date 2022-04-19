package ro.sda.finalProject.carRental.entities;

import lombok.Data;
import ro.sda.finalProject.carRental.model.Status;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
