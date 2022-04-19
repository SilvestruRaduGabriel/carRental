package ro.sda.finalProject.carRental.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class CustomerForm {

    private Integer customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
