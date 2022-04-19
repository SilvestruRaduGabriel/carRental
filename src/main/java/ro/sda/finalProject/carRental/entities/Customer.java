package ro.sda.finalProject.carRental.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name="Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id", nullable = false)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;





}
