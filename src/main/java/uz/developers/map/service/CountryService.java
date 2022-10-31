package uz.developers.map.service;

import uz.developers.map.entity.Country;
import uz.developers.map.payload.CountryDto;
import uz.developers.map.payload.Result;

import java.util.List;

public interface CountryService {
    List<Country> getCountries();

    Country getCountry(Integer id);

    Result addCountry(CountryDto countryDto);

    Result editCountry(Integer id, CountryDto countryDto);

    Result deleteCountry(Integer id);
}
