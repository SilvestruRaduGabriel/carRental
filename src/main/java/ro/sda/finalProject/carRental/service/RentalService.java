package ro.sda.finalProject.carRental.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.finalProject.carRental.entities.Rental;
import ro.sda.finalProject.carRental.errors.EntityNotFoundError;
import ro.sda.finalProject.carRental.mappers.RentalMapper;
import ro.sda.finalProject.carRental.model.RentalForm;
import ro.sda.finalProject.carRental.repository.RentalRepository;

import java.util.List;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private RentalMapper rentalMapper;

    public List<Rental> findAllRentals() {
        return rentalRepository.findAll();
    }

    public void createRental(RentalForm form) {
        Rental rental = rentalMapper.convertToEntity(form);
        rentalRepository.save(rental);
    }

    public RentalForm findById(int id) {
        Rental entityRental = rentalRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Rental with %s does not exist", id)));
        return rentalMapper.convertToDto(entityRental);
    }

    public void deleteById(int id) {
        rentalRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Rental with %s does not exis", id)));
        rentalRepository.deleteById(id);
    }


}
