package ro.sda.finalProject.carRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.finalProject.carRental.entities.Rental;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
}
