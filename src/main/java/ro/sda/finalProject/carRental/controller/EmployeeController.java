package ro.sda.finalProject.carRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ro.sda.finalProject.carRental.entities.Branch;
import ro.sda.finalProject.carRental.entities.Employee;
import ro.sda.finalProject.carRental.exceptions.EntityNotFoundException;
import ro.sda.finalProject.carRental.model.BranchForm;
import ro.sda.finalProject.carRental.model.EmployeeForm;
import ro.sda.finalProject.carRental.model.Position;
import ro.sda.finalProject.carRental.service.BranchService;
import ro.sda.finalProject.carRental.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employeeList", employees);
        return "employeeList"; // numele html
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("employeeForm", new EmployeeForm());
        model.addAttribute("positions", Position.values());
        return "employee_create";
    }

    @PostMapping("/create")
    public String createEmployee(@ModelAttribute("employeeForm") @Valid EmployeeForm employeeForm, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "employee_create";
        }
        employeeService.createEmployee(employeeForm);
        return "redirect:/employee/";
    }

    @GetMapping("/edit/{employeeId}")
    public String showEditForm(@PathVariable("employeeId") int id, Model model) {
        EmployeeForm employeeForm = employeeService.findById(id);
        model.addAttribute("employeeForm", employeeForm);
        return "employee_create";
    }

    @GetMapping("/delete/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") int id, Model model) {
        employeeService.deleteById(id);
        return "redirect:/employee";
    }
}
