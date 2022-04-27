package ro.sda.finalProject.carRental.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerForm {
    private Integer customerId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Email
    private String email;
    @NotNull
    @Max(100)
    private String address;
}
