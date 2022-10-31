package uz.developers.map.service;

import uz.developers.map.entity.Continent;
import uz.developers.map.payload.ContinentDto;
import uz.developers.map.payload.Result;

import java.util.List;

public interface ContinentService {
    List<Continent> getContinents();

    Continent getContinent(Integer id);

    Result addContinent(ContinentDto continentDto);

    Result editContinent(Integer id, ContinentDto continentDto);

    Result deleteContinent(Integer id);
}
