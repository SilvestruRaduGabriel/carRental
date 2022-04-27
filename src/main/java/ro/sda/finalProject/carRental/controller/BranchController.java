package ro.sda.finalProject.carRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ro.sda.finalProject.carRental.entities.Branch;
import ro.sda.finalProject.carRental.exceptions.EntityNotFoundException;
import ro.sda.finalProject.carRental.model.BranchForm;
import ro.sda.finalProject.carRental.service.BranchService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping("/branches")
    public String showAllBranches(Model model) {
        List<Branch> branches = branchService.getAllBranches();
        model.addAttribute("branchesList", branches);
        return "branchesList";
    }

    @GetMapping("/branch")
    public String showForm(Model model) {
        model.addAttribute("branchForm", new BranchForm());
        return "branch_create";
    }

    @PostMapping("/branch/create")
    public String createBranch(@ModelAttribute("branchForm") @Valid BranchForm branchForm, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "branch_create";
        }
        branchService.createBranch(branchForm);
        return "redirect:/branch";
    }

    @GetMapping("/branches/edit/{branchId}")
    public String showEditForm(@PathVariable("branchId") int id, Model model) throws EntityNotFoundException {
        BranchForm branchForm = branchService.findById(id);
        model.addAttribute("branchForm", branchForm);
        return "branch_create";
    }

    @GetMapping("/branches/delete/{branchId}")
    public String deleteBranch(@PathVariable("branchId") int id, Model model) {
        branchService.deleteById(id);
        return "redirect:/branch";
    }
}
