package ro.sda.finalProject.carRental.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


import javax.persistence.*;
import java.util.List;

@Slf4j
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

    @OneToMany(mappedBy = "client")
    private List<Reservation> reservations;
}
