package ro.sda.finalProject.carRental.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.finalProject.carRental.entities.Branch;
import ro.sda.finalProject.carRental.entities.Employee;
import ro.sda.finalProject.carRental.exceptions.EntityNotFoundException;
import ro.sda.finalProject.carRental.mappers.BranchMapper;
import ro.sda.finalProject.carRental.model.BranchForm;
import ro.sda.finalProject.carRental.model.Position;
import ro.sda.finalProject.carRental.repository.BranchRepository;
import ro.sda.finalProject.carRental.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchService {

    @Autowired
    private BranchMapper branchMapper;

    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private EmployeeService employeeService;

    public List<BranchForm> getAllBranches() {
        return branchRepository.findAll().stream().map((b)->branchMapper.convertToDto(b)).collect(Collectors.toList());
    }

    public void createBranch(BranchForm branchForm) {
        Branch branch = branchMapper.convertToEntity(branchForm);
        if (branch.getManager()!=null){
            employeeService.updateManager(branch);
        }
        branchRepository.save(branch);
    }

    public BranchForm findById(int id) throws EntityNotFoundException {
        Branch entityBranch = branchRepository.findById(id).orElseThrow(() ->  new EntityNotFoundException(String.format("Branch with %s does not exitst" , id)));
        return branchMapper.convertToDto(entityBranch);
    }

    public void deleteById(int id) {
        branchRepository.findById(id).orElseThrow(() -> new javax.persistence.EntityNotFoundException(String.format("Branch with %s does not exitst" , id)));
        branchRepository.deleteById(id);

    }


}
