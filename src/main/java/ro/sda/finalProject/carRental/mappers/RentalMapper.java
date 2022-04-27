package ro.sda.finalProject.carRental.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.finalProject.carRental.entities.Rental;
import ro.sda.finalProject.carRental.model.RentalForm;
import ro.sda.finalProject.carRental.repository.RentalRepository;

@Service
public class RentalMapper implements Mapper<Rental, RentalForm> {

    @Autowired
    private RentalRepository rentalRepository;

    @Override
    public RentalForm convertToDto(Rental entity) {
        RentalForm rentalForm = new RentalForm();
        rentalForm.setId(entity.getId());
        rentalForm.setName(entity.getName());
        rentalForm.setDomainInternet(entity.getDomainInternet());
        rentalForm.setAddress(entity.getAddress());
        rentalForm.setOwner(entity.getOwner());
        rentalForm.setLogoType(entity.getLogoType());
        return rentalForm;
    }

    @Override
    public Rental convertToEntity(RentalForm dto) {
        Rental rental;
        if (dto.getId() != null) {
            rental = rentalRepository.findById(dto.getId()).orElse(new Rental());
        } else {
            rental = new Rental();
        }
        rental.setId(dto.getId());
        rental.setName(dto.getName());
        rental.setDomainInternet(dto.getDomainInternet());
        rental.setAddress(dto.getAddress());
        rental.setOwner(dto.getOwner());
        rental.setLogoType(dto.getLogoType());
        return rental;
    }
}
