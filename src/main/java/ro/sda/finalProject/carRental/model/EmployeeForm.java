package ro.sda.finalProject.carRental.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ro.sda.finalProject.carRental.entities.Branch;

import javax.validation.constraints.NotNull;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeForm {

    private Integer id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Position position;

    private Integer branchId;

    private BranchForm branchForm;

    public String getName(){
        return firstName + " " + lastName;
    }
}
