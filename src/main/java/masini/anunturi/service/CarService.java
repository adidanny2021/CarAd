package masini.anunturi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import masini.anunturi.CarCategory;
import masini.anunturi.entity.Car;
import masini.anunturi.entity.CarDao;
import masini.anunturi.rest.dto.CarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CarService {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private CarDao carDao;

    public void createCar(CarDto carDto) {
        Car newCar = objectMapper.convertValue(carDto, Car.class);
        newCar.setId(UUID.randomUUID());

        carDao.save(newCar);
    }

    public void deleteCar(UUID carId) {
        Car car = carDao.findById(carId).orElse(null);
        if (car != null) {
            carDao.delete(car);
        }
    }

    public CarDto getCarById(UUID id) {
        Car car = carDao.findById(id).get();
        CarDto newCar = objectMapper.convertValue(car, CarDto.class);
        return newCar;
    }


}
