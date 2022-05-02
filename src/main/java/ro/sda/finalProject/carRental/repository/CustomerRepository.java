package ro.sda.finalProject.carRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.finalProject.carRental.entities.Customer;
@Repository
public interface CustomerRepository extends JpaRepository <Customer,Integer>{
}
