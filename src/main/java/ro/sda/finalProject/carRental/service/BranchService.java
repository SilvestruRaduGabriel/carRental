package ro.sda.finalProject.carRental.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.finalProject.carRental.entities.Branch;
import ro.sda.finalProject.carRental.exceptions.EntityNotFoundException;
import ro.sda.finalProject.carRental.mapper.BranchMapper;
import ro.sda.finalProject.carRental.model.BranchForm;
import ro.sda.finalProject.carRental.repository.BranchRepository;

import java.util.List;

@Service
public class BranchService {

    @Autowired
    private BranchMapper branchMapper;

    @Autowired
    private BranchRepository branchRepository;

    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    public void createBranch(BranchForm branchForm) {
        Branch branch = branchMapper.convertToEntity(branchForm);
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
