package ro.sda.finalProject.carRental.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ro.sda.finalProject.carRental.entities.Employee;

import javax.validation.constraints.NotNull;



@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BranchForm {


    private Integer id;

    @NotNull
    private String city;

    @NotNull
    private String address;

    private Integer managerId;
    private EmployeeForm manager;

    private String name;
}
