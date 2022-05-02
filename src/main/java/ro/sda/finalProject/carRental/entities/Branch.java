package ro.sda.finalProject.carRental.entities;
import lombok.Data;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String city;
    private String address;

    @OneToMany(mappedBy = "branch")
    private List<Car> availableCars;

    @OneToMany(mappedBy = "branch")
    private List<Employee> employees;



}
