package uz.developers.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.jpa_relationships_tasks.task1.model.Mark;
import uz.developers.jpa_relationships_tasks.task1.payload.MarkDto;
import uz.developers.jpa_relationships_tasks.task1.repository.MarkRepository;
import uz.developers.jpa_relationships_tasks.task2.entity.District;
import uz.developers.jpa_relationships_tasks.task2.payload.DistrictDto;
import uz.developers.jpa_relationships_tasks.task2.repository.DistrictRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    DistrictRepository districtRepository;


    @GetMapping
    public List<District> getDistricts(){
        List<District> districts = districtRepository.findAll();
        return districts;
    }

    @PostMapping
    public String addDistrict(@RequestBody DistrictDto districtDto){
        District district = new District();
        district.setName(districtDto.getName());
        districtRepository.save(district);
        return "District is added";
    }

    @PutMapping("/{id}")
    public String editDistrict(@PathVariable Integer id,@RequestBody DistrictDto districtDto){
        Optional<District> optionalDistrict = districtRepository.findById(id);
        if (optionalDistrict.isPresent()) {
            District district = optionalDistrict.get();
            district.setName(districtDto.getName());
            districtRepository.save(district);
            return "District is edited";
        }
        return "District not found";
    }
    @DeleteMapping("/{id}")
    public String deleteDistrict(@PathVariable Integer id){
        districtRepository.deleteById(id);
        return "District is deleted";
    }

}
