package ro.sda.finalProject.carRental.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.finalProject.carRental.entities.Employee;
import ro.sda.finalProject.carRental.mapper.EmployeeMapper;
import ro.sda.finalProject.carRental.model.EmployeeForm;
import ro.sda.finalProject.carRental.repository.EmployeeRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void createEmployee(EmployeeForm employeeForm) {
        Employee employee = employeeMapper.convertToEntity(employeeForm);
        employeeRepository.save(employee);
    }

    public EmployeeForm findById(int id) {
        Employee entityEmployee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Branch with %s does not exitst", id)));
        return employeeMapper.convertToDto(entityEmployee);
    }

    public void deleteById(int id) {
        employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Branch with %s does not exitst", id)));
        employeeRepository.deleteById(id);
    }
}
