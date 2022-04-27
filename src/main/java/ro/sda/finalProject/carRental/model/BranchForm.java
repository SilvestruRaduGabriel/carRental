package ro.sda.finalProject.carRental.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;



@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BranchForm {

    @NotNull
    private Integer id;

    @NotNull
    private String city;

    @NotNull
    private String address;
}
