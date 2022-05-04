package ro.sda.finalProject.carRental.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.finalProject.carRental.entities.Car;
import ro.sda.finalProject.carRental.model.CarForm;
import ro.sda.finalProject.carRental.repository.CarRepository;

@Service
public class CarMapper implements Mapper<Car,CarForm> {

    @Autowired
    private CarRepository carRepository;

    @Override
    public CarForm convertToDto(Car entity) {

        CarForm carForm = new CarForm();
        carForm.setId(entity.getId());
        carForm.setBrand(entity.getBrand());
        carForm.setModel(entity.getModel());
        carForm.setBodyType(entity.getBodyType());
        carForm.setYear(entity.getYear());
        carForm.setColour(entity.getColour());
        carForm.setMileage(entity.getMileage());
        carForm.setStatus(entity.getStatus());
        carForm.setAmount(entity.getAmount());
        return carForm;

    }

    @Override
    public Car convertToEntity(CarForm dto) {
        Car car;
        if (dto.getId() != null) {
            car = carRepository.findById(dto.getId()).orElse(new Car());
        } else {
            car = new Car();
        }
        car.setId(dto.getId());
        car.setBrand(dto.getBrand());
        car.setModel(dto.getModel());
        car.setBodyType(dto.getBodyType());
        car.setYear(dto.getYear());
        car.setColour(dto.getColour());
        car.setMileage(dto.getMileage());
        car.setStatus(dto.getStatus());
        car.setAmount(dto.getAmount());
        return car;
    }
}
