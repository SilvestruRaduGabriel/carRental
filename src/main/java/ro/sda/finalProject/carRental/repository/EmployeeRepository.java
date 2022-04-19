package ro.sda.finalProject.carRental.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.finalProject.carRental.entities.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
