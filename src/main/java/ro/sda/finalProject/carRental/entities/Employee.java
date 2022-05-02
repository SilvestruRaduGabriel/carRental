package ro.sda.finalProject.carRental.entities;

import lombok.Data;
import ro.sda.finalProject.carRental.model.Position;

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
    private Position position;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

}
