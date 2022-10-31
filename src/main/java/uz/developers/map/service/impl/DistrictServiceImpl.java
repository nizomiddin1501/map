package uz.developers.map.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uz.developers.map.entity.District;
import uz.developers.map.payload.DistrictDto;
import uz.developers.map.payload.Result;
import uz.developers.map.repository.DistrictRepository;
import uz.developers.map.service.DistrictService;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    DistrictRepository districtRepository;

    @Override
    public List<District> getDistricts() {
        return districtRepository.findAll();
    }

    @Override
    public District getDistrict(Integer id) {
        Optional<District> optionalDistrict = districtRepository.findById(id);
        if (optionalDistrict.isPresent()) {
            return optionalDistrict.get();
        }
        return null;
    }

    @Override
    public Result addDistrict(DistrictDto districtDto) {
        District district = new District();
        district.setName(districtDto.getName());
        districtRepository.save(district);
        return new Result("District is added",true);
    }

    @Override
    public Result editDistrict(Integer id, DistrictDto districtDto) {
        Optional<District> optionalDistrict = districtRepository.findById(id);
        if (optionalDistrict.isEmpty()) {
            return new Result("District is not found",false);
        }
        District district = optionalDistrict.get();
        district.setName(districtDto.getName());
        districtRepository.save(district);
        return new Result("District is edited",true);
    }

    @Override
    public Result deleteDistrict(Integer id) {
        districtRepository.deleteById(id);
        return new Result("District is deleted",true);
    }
}
