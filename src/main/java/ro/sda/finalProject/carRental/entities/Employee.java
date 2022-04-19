package ro.sda.finalProject.carRental.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String firstName;
    private String lastName;
    private String position;

}
