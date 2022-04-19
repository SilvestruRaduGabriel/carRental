package ro.sda.finalProject.carRental.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.finalProject.carRental.entities.Branch;



public interface BranchRepository extends JpaRepository<Branch, Integer> {
}
