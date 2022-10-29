package uz.developers.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.jpa_relationships_tasks.task1.model.Mark;
import uz.developers.jpa_relationships_tasks.task1.payload.MarkDto;
import uz.developers.jpa_relationships_tasks.task1.repository.MarkRepository;
import uz.developers.jpa_relationships_tasks.task2.entity.Continent;
import uz.developers.jpa_relationships_tasks.task2.payload.ContinentDto;
import uz.developers.jpa_relationships_tasks.task2.repository.ContinentRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/continent")
public class ContinentController {


    @Autowired
    ContinentRepository continentRepository;


    @GetMapping
    public List<Continent> getContinents(){
        List<Continent> continents = continentRepository.findAll();
        return continents;
    }

    @PostMapping
    public String addMark(@RequestBody ContinentDto continentDto){
        Continent continent = new Continent();
        continent.setName(continentDto.getName());
        continentRepository.save(continent);
        return "Continent is added";
    }

    @PutMapping("/{id}")
    public String editContinent(@PathVariable Integer id,@RequestBody ContinentDto continentDto){
        Optional<Continent> optionalContinent = continentRepository.findById(id);
        if (optionalContinent.isPresent()) {
            Continent continent = optionalContinent.get();
            continent.setName(continentDto.getName());
            continentRepository.save(continent);
            return "Continent is edited";
        }
        return "Continent not found";
    }
    @DeleteMapping("/{id}")
    public String deleteContinent(@PathVariable Integer id){
        continentRepository.deleteById(id);
        return "Continent is deleted";
    }
}
