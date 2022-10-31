package uz.developers.map.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.map.entity.Country;
import uz.developers.map.payload.CountryDto;
import uz.developers.map.payload.Result;
import uz.developers.map.repository.CountryRepository;
import uz.developers.map.service.CountryService;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    CountryRepository countryRepository;


    @Override
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountry(Integer id) {
        Optional<Country> optionalCountry = countryRepository.findById(id);
        if (optionalCountry.isPresent()) {
            return optionalCountry.get();
        }
        return null;
    }

    @Override
    public Result addCountry(CountryDto countryDto) {
        Country country = new Country();
        country.setName(countryDto.getName());
        countryRepository.save(country);
        return new Result("Country is added",true);
    }

    @Override
    public Result editCountry(Integer id, CountryDto countryDto) {
        Optional<Country> optionalCountry = countryRepository.findById(id);
        if (optionalCountry.isEmpty()) {
            return new Result("Country is not found",false);
        }
        Country country = optionalCountry.get();
        country.setName(countryDto.getName());
        countryRepository.save(country);
        return new Result("Country is edited",true);

    }
    @Override
    public Result deleteCountry(Integer id) {
        countryRepository.deleteById(id);
        return new Result("Country is deleted",true);
    }
}
