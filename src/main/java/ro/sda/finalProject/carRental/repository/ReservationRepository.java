package ro.sda.finalProject.carRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.finalProject.carRental.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
