package ro.sda.finalProject.carRental.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.finalProject.carRental.entities.Branch;
import ro.sda.finalProject.carRental.entities.Employee;
import ro.sda.finalProject.carRental.mappers.EmployeeMapper;
import ro.sda.finalProject.carRental.model.EmployeeForm;
import ro.sda.finalProject.carRental.model.Position;
import ro.sda.finalProject.carRental.repository.BranchRepository;
import ro.sda.finalProject.carRental.repository.EmployeeRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private BranchRepository branchRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void createEmployee(EmployeeForm employeeForm) {
        Employee employee = employeeMapper.convertToEntity(employeeForm);
        employeeRepository.save(employee);
    }

    public EmployeeForm findById(int id) {
        Employee entityEmployee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Employee with %s does not exitst", id)));
        return employeeMapper.convertToDto(entityEmployee);
    }

    public void deleteById(int id) {
        employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Branch with %s does not exitst", id)));
        employeeRepository.deleteById(id);
    }

    public List<EmployeeForm> getEmployeesByBranch(int branchId) {
        Branch branch = branchRepository.findById(branchId).orElseThrow(()-> new EntityNotFoundException(String.format("Branch with %s does not exitst", branchId)));
        List<Employee> employeeList =employeeRepository.findAllByBranch(branch);

        return  employeeList.stream().map((e)->employeeMapper.convertToDto(e)).collect(Collectors.toList());
    }
    
    public void updateManager(Branch branch){
        Employee currentManager = branch.getManager();
        
        Employee previousManager = employeeRepository.findEmployeeByBranchAndPosition(branch,Position.MANAGER);
        if (previousManager !=null) {
            previousManager.setPosition(Position.EMPLOYEE);
            employeeRepository.save(previousManager);
        }
        
        
        if (!currentManager.getPosition().equals(Position.MANAGER)){
            currentManager.setPosition(Position.MANAGER);
            employeeRepository.save(currentManager);
        }
    }
}
