package ro.sda.finalProject.carRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.finalProject.carRental.entities.Customer;

public interface CustomerRepository extends JpaRepository <Customer,Integer>{
}
