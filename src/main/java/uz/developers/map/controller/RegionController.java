package uz.developers.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.jpa_relationships_tasks.task1.model.Mark;
import uz.developers.jpa_relationships_tasks.task1.payload.MarkDto;
import uz.developers.jpa_relationships_tasks.task1.repository.MarkRepository;
import uz.developers.jpa_relationships_tasks.task2.entity.Region;
import uz.developers.jpa_relationships_tasks.task2.payload.RegionDto;
import uz.developers.jpa_relationships_tasks.task2.repository.RegionRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    RegionRepository regionRepository;


    @GetMapping
    public List<Region> getRegions(){
        List<Region> regions = regionRepository.findAll();
        return regions;
    }

    @PostMapping
    public String addRegion(@RequestBody RegionDto regionDto){
        Region region = new Region();
        region.setName(regionDto.getName());
        regionRepository.save(region);
        return "Region is added";
    }

    @PutMapping("/{id}")
    public String editRegion(@PathVariable Integer id,@RequestBody RegionDto regionDto){
        Optional<Region> optionalRegion = regionRepository.findById(id);
        if (optionalRegion.isPresent()) {
            Region region = optionalRegion.get();
            region.setName(regionDto.getName());
            regionRepository.save(region);
            return "Region is edited";
        }
        return "Region not found";
    }
    @DeleteMapping("/{id}")
    public String deleteRegion(@PathVariable Integer id){
        regionRepository.deleteById(id);
        return "Region is deleted";
    }
}
