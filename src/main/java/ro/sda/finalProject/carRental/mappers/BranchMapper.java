package ro.sda.finalProject.carRental.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.finalProject.carRental.entities.Branch;
import ro.sda.finalProject.carRental.model.BranchForm;
import ro.sda.finalProject.carRental.repository.BranchRepository;

@Service
public class BranchMapper implements Mapper<Branch , BranchForm> {

    @Autowired
    private final BranchRepository branchRepository;

    public BranchMapper(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    } //

    @Override
    public BranchForm convertToDto(Branch entity) {
        BranchForm branchForm = new BranchForm();
        branchForm.setId(entity.getId());
        branchForm.setCity(entity.getCity());
        branchForm.setAddress(entity.getAddress());

        return branchForm;
    }

    @Override
    public Branch convertToEntity(BranchForm dto) {
        Branch branch;

        if (dto.getId() != null) {
            branch = branchRepository.findById(dto.getId()).orElse(new Branch());
        }else {
            branch = new Branch();
        }
        branch.setId(dto.getId());
        branch.setCity(dto.getCity());
        branch.setAddress(dto.getAddress());

        return branch;
    }
}
