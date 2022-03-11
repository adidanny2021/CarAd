package masini.anunturi.rest;

import masini.anunturi.rest.dto.AdDto;
import masini.anunturi.rest.dto.CarDto;
import masini.anunturi.service.AdService;
import masini.anunturi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("ad")
public class AdRESTService {

    @Autowired
    private AdService adService;

    @PostMapping
    public void createAd(@RequestBody AdDto adDto) {
        adService.createAd(adDto);
    }

    @DeleteMapping(path = "/{adId}")
    public void deleteCar(@PathVariable UUID adId) {
        adService.deleteAd(adId);
    }

    @GetMapping("/{id}")
    public AdDto getAd(@PathVariable UUID id) {
        return adService.getAdById(id);
    }
}
