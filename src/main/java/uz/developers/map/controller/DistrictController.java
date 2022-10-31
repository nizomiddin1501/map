package uz.developers.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.map.entity.Country;
import uz.developers.map.entity.District;
import uz.developers.map.payload.CountryDto;
import uz.developers.map.payload.DistrictDto;
import uz.developers.map.payload.Result;
import uz.developers.map.service.CountryService;
import uz.developers.map.service.DistrictService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/district")
public class DistrictController {

    @Autowired
    DistrictService districtService;

    @GetMapping
    public List<District> getDistricts(){
        return districtService.getDistricts();
    }
    @GetMapping("/{id}")
    public District getDistrict(@PathVariable Integer id){
        return districtService.getDistrict(id);
    }

    @PostMapping
    public Result addDistrict(@RequestBody DistrictDto districtDto){
        return districtService.addDistrict(districtDto);
    }

    @PutMapping("/{id}")
    public Result editDistrict(@PathVariable Integer id, @RequestBody DistrictDto districtDto){
        return districtService.editDistrict(id,districtDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteDistrict(@PathVariable Integer id){
        return districtService.deleteDistrict(id);
    }

}
