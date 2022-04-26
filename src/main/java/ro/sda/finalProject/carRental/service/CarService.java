package ro.sda.finalProject.carRental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.finalProject.carRental.entities.Car;
import ro.sda.finalProject.carRental.repository.CarRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public Car findById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cannot find Car with id " + id));
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    void delete(Long id) {
        carRepository.deleteById(id);
    }
}
