package ro.sda.finalProject.carRental.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.finalProject.carRental.entities.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
