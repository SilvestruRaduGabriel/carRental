package ro.sda.finalProject.carRental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.finalProject.carRental.entities.Car;
import ro.sda.finalProject.carRental.mappers.CarMapper;
import ro.sda.finalProject.carRental.model.CarForm;
import ro.sda.finalProject.carRental.model.Status;
import ro.sda.finalProject.carRental.repository.CarRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarMapper carMapper;


    public void create(CarForm carForm) {
        Car carForm1 = carMapper.convertToEntity(carForm);
        carRepository.save(carForm1);
    }

    public Car findById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cannot find Car with id " + id));
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public List<Car> findTop3(){
        return carRepository.findFirst3ByStatus(Status.AVAILABLE);
    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }
}
