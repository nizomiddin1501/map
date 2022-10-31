package uz.developers.map.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.map.entity.Continent;
import uz.developers.map.payload.ContinentDto;
import uz.developers.map.payload.Result;
import uz.developers.map.repository.ContinentRepository;
import uz.developers.map.service.ContinentService;

import java.util.List;
import java.util.Optional;

@Service
public class ContinentServiceImpl implements ContinentService {
    @Autowired
    ContinentRepository continentRepository;

    @Override
    public List<Continent> getContinents() {
       return continentRepository.findAll();
    }

    @Override
    public Continent getContinent(Integer id) {
        Optional<Continent> optionalContinent = continentRepository.findById(id);
        if (optionalContinent.isPresent()) {
            return optionalContinent.get();
        }
        return null;
    }

    @Override
    public Result addContinent(ContinentDto continentDto) {
        Continent continent = new Continent();
        continent.setName(continentDto.getName());
        continentRepository.save(continent);
        return new Result("Continent is saved",true);
    }

    @Override
    public Result editContinent(Integer id, ContinentDto continentDto) {
        Optional<Continent> optionalContinent = continentRepository.findById(id);
        if (optionalContinent.isEmpty()) {
           return new Result("Continent is not found",false);
        }
        Continent continent = optionalContinent.get();
        continent.setName(continentDto.getName());
        continentRepository.save(continent);
        return new Result("Continent is edited",true);
    }

    @Override
    public Result deleteContinent(Integer id) {
        continentRepository.deleteById(id);
        return new Result("Continent is deleted",true);
    }
}
