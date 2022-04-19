package ro.sda.finalProject.carRental.entities;
import lombok.Data;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String City;
    private String address;

//    @OneToMany
//    private List<Employee> employees;
// available cars ( dar inca nu am entitatea )


}