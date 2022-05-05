package ro.sda.finalProject.carRental.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.Email;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactForm {

    private String name;
    @Email
    private String email;
    private String subject;
    private String notes;

}
