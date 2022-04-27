package ro.sda.finalProject.carRental.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RentalForm {

    private Integer id;
    private String name;
    private String domainInternet;
    private String address;
    private String owner;

    private byte[] logoType;

}
