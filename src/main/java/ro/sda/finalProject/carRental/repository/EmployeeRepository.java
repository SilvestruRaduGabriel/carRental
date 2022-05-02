package ro.sda.finalProject.carRental.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.finalProject.carRental.entities.Branch;
import ro.sda.finalProject.carRental.entities.Employee;
import ro.sda.finalProject.carRental.model.Position;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByBranch(Branch branch);
    Employee findEmployeeByBranchAndPosition(Branch branch, Position position);
}
