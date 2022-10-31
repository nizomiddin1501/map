package uz.developers.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.map.entity.Addresss;
import uz.developers.map.entity.Country;
import uz.developers.map.payload.AddressDto;
import uz.developers.map.payload.CountryDto;
import uz.developers.map.payload.Result;
import uz.developers.map.service.AddressService;
import uz.developers.map.service.CountryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping
    public List<Country> getCountries(){
        return countryService.getCountries();
    }
    @GetMapping("/{id}")
    public Country getCountry(@PathVariable Integer id){
        return countryService.getCountry(id);
    }

    @PostMapping
    public Result addCountry(@RequestBody CountryDto countryDto){
        return countryService.addCountry(countryDto);
    }

    @PutMapping("/{id}")
    public Result editCountry(@PathVariable Integer id, @RequestBody CountryDto countryDto){
        return countryService.editCountry(id,countryDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteCountry(@PathVariable Integer id){
        return countryService.deleteCountry(id);
    }

}
