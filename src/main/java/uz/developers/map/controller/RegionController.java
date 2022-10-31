package uz.developers.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.map.entity.Country;
import uz.developers.map.entity.Region;
import uz.developers.map.payload.CountryDto;
import uz.developers.map.payload.RegionDto;
import uz.developers.map.payload.Result;
import uz.developers.map.service.CountryService;
import uz.developers.map.service.RegionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    RegionService regionService;

    @GetMapping
    public List<Region> getRegions(){
        return regionService.getRegions();
    }
    @GetMapping("/{id}")
    public Region getRegion(@PathVariable Integer id){
        return regionService.getRegion(id);
    }

    @PostMapping
    public Result addRegion(@RequestBody RegionDto regionDto){
        return regionService.addRegion(regionDto);
    }

    @PutMapping("/{id}")
    public Result editRegion(@PathVariable Integer id, @RequestBody RegionDto regionDto){
        return regionService.editRegion(id,regionDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteRegion(@PathVariable Integer id){
        return regionService.deleteRegion(id);
    }
}
