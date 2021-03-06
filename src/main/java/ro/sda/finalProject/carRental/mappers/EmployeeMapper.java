package ro.sda.finalProject.carRental.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.finalProject.carRental.entities.Branch;
import ro.sda.finalProject.carRental.entities.Employee;
import ro.sda.finalProject.carRental.model.BranchForm;
import ro.sda.finalProject.carRental.model.EmployeeForm;
import ro.sda.finalProject.carRental.repository.BranchRepository;
import ro.sda.finalProject.carRental.repository.EmployeeRepository;

@Service
public class EmployeeMapper implements Mapper<Employee , EmployeeForm> {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Autowired
    private BranchRepository branchRepository;


    public EmployeeMapper(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    // DTO (Data transfer object)
    public EmployeeForm convertToDto(Employee entity) {
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.setId(entity.getId());
        employeeForm.setFirstName(entity.getFirstName());
        employeeForm.setLastName(entity.getLastName());
        employeeForm.setPosition(entity.getPosition());
        if(entity.getBranch() !=null){
            employeeForm.setBranchId(entity.getBranch().getId());
        }
        return employeeForm;
    }

    @Override
    public Employee convertToEntity(EmployeeForm dto) {
        Employee employee;

        if (dto.getId() != null) {
            employee = employeeRepository.findById(dto.getId()).orElse(new Employee());
        }else {
            employee = new Employee();
        }
        employee.setId(dto.getId());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setPosition(dto.getPosition());
        if (dto.getBranchId() !=null){
            employee.setBranch(branchRepository.findById(dto.getBranchId()).orElse(new Branch()));
        }

        return employee;
    }
}
