package uz.developers.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.jpa_relationships_tasks.task1.model.Mark;
import uz.developers.jpa_relationships_tasks.task1.payload.MarkDto;
import uz.developers.jpa_relationships_tasks.task1.repository.MarkRepository;
import uz.developers.jpa_relationships_tasks.task2.entity.Country;
import uz.developers.jpa_relationships_tasks.task2.payload.CountryDto;
import uz.developers.jpa_relationships_tasks.task2.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryRepository countryRepository;


    @GetMapping
    public List<Country> getCountries(){
        List<Country> countryList = countryRepository.findAll();
        return countryList;
    }

    @PostMapping
    public String addCountry(@RequestBody CountryDto countryDto){
        Country country = new Country();
        country.setName(countryDto.getName());
        countryRepository.save(country);
        return "Country is added";
    }

    @PutMapping("/{id}")
    public String editCountry(@PathVariable Integer id,@RequestBody CountryDto countryDto){
        Optional<Country> optionalCountry = countryRepository.findById(id);
        if (optionalCountry.isPresent()) {
            Country country = optionalCountry.get();
            country.setName(countryDto.getName());
            countryRepository.save(country);
            return "Country is edited";
        }
        return "Country not found";
    }
    @DeleteMapping("/{id}")
    public String deleteCountry(@PathVariable Integer id){
        countryRepository.deleteById(id);
        return "Country is deleted";
    }
}
