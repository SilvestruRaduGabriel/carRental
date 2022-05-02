package ro.sda.finalProject.carRental.entities;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String city;
    private String address;
    private String name;

    @OneToMany(mappedBy = "branch")
    private List<Car> availableCars;

    @OneToMany(mappedBy = "branch")
    private List<Employee> employees;

    @OneToOne
    private Employee manager;
}
