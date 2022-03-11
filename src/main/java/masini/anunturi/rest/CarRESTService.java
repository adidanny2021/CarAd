package masini.anunturi.rest;

import masini.anunturi.entity.Car;
import masini.anunturi.rest.dto.CarDto;
import masini.anunturi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("car")
public class CarRESTService {

    @Autowired
    private CarService carService;

    @PostMapping
    public void createCar(CarDto carDto) {
        carService.createCar(carDto);
    }

    @DeleteMapping(path = "/{carId}")
    public void deleteCar(@PathVariable UUID carId) {
        carService.deleteCar(carId);
    }

    @GetMapping("/{id}")
    public CarDto getCarById(@PathVariable UUID id) {
        return carService.getCarById(id);
    }
}
