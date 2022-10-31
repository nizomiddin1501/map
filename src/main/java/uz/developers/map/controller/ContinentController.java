package uz.developers.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.map.entity.Addresss;
import uz.developers.map.entity.Continent;
import uz.developers.map.payload.AddressDto;
import uz.developers.map.payload.ContinentDto;
import uz.developers.map.payload.Result;
import uz.developers.map.service.AddressService;
import uz.developers.map.service.ContinentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/continent")
public class ContinentController {


    @Autowired
    ContinentService continentService;

    @GetMapping
    public List<Continent> getContinents(){
        return continentService.getContinents();
    }
    @GetMapping("/{id}")
    public Continent getContinent(@PathVariable Integer id){
        return continentService.getContinent(id);
    }

    @PostMapping
    public Result addContinent(@RequestBody ContinentDto continentDto){
        return continentService.addContinent(continentDto);
    }

    @PutMapping("/{id}")
    public Result editContinent(@PathVariable Integer id, @RequestBody ContinentDto continentDto){
        return continentService.editContinent(id,continentDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteContinent(@PathVariable Integer id){
        return continentService.deleteContinent(id);
    }

}
