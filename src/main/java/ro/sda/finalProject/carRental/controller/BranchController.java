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
import ro.sda.finalProject.carRental.service.BranchService;
import ro.sda.finalProject.carRental.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String showAllBranches(Model model) {
        List<BranchForm> branches = branchService.getAllBranches();
        model.addAttribute("branchList", branches);
        return "branchList";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("branchForm", new BranchForm());
        return "branch_create";
    }

    @PostMapping("/create")
    public String createBranch(@ModelAttribute("branchForm") @Valid BranchForm branchForm, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "branch_create";
        }
        branchService.createBranch(branchForm);
        return "redirect:/branch/";
    }

    @GetMapping("/edit/{branchId}")
    public String showEditForm(@PathVariable("branchId") int branchId, Model model) throws EntityNotFoundException {
        BranchForm branchForm = branchService.findById(branchId);
        model.addAttribute("branchForm", branchForm);
        List<EmployeeForm> employeesByBranch = employeeService.getEmployeesByBranch(branchId);
        model.addAttribute("employeesList",employeesByBranch);
        return "branch_create";
    }

    @GetMapping("/delete/{branchId}")
    public String deleteBranch(@PathVariable("branchId") int id, Model model) {
        branchService.deleteById(id);
        return "redirect:/branch/";
    }
}
