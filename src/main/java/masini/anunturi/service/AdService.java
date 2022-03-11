package masini.anunturi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import masini.anunturi.entity.Ad;
import masini.anunturi.entity.AdDao;
import masini.anunturi.entity.Car;
import masini.anunturi.entity.CarDao;
import masini.anunturi.rest.dto.AdDto;
import masini.anunturi.rest.dto.CarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AdService {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private AdDao adDao;

    @Autowired
    private CarDao carDao;

    public void createAd(AdDto adDto) {
        Ad ad = new Ad();
        ad.setDescription(adDto.getDescription());
        ad.setPrice(adDto.getPrice());
        ad.setId(UUID.randomUUID());

        Optional<Car> car = carDao.findById(adDto.getCarId());

        if (car.isPresent()) {
            ad.setCar(car.get());
        }

        adDao.save(ad);
    }

    public void deleteAd(UUID adId) {
        Optional<Ad> potentialAd = adDao.findById(adId);

        if (potentialAd.isPresent()) {
            adDao.delete(potentialAd.get());
        }
    }

    public AdDto getAdById(UUID id) {
        Optional<Ad> potentialAd = adDao.findById(id);

        if (potentialAd.isPresent()) {
            Ad ad = potentialAd.get();

            AdDto foundAd = new AdDto();
            foundAd.setId(ad.getId());
            foundAd.setCarId(ad.getCar().getId());
            foundAd.setDescription(ad.getDescription());
            foundAd.setPrice(ad.getPrice());

            return foundAd;
        } else {
            return null;
        }
    }

}
