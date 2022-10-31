package uz.developers.map.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uz.developers.map.entity.Region;
import uz.developers.map.payload.RegionDto;
import uz.developers.map.payload.Result;
import uz.developers.map.repository.RegionRepository;
import uz.developers.map.service.RegionService;

import java.util.List;
import java.util.Optional;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    RegionRepository regionRepository;

    @Override
    public List<Region> getRegions() {
        return regionRepository.findAll();
    }

    @Override
    public Region getRegion(Integer id) {
        Optional<Region> optionalRegion = regionRepository.findById(id);
        if (optionalRegion.isPresent()) {
            return optionalRegion.get();
        }
        return null;
    }

    @Override
    public Result addRegion(RegionDto regionDto) {
        Region region = new Region();
        region.setName(regionDto.getName());
        regionRepository.save(region);
        return new Result("Region is added",true);
    }

    @Override
    public Result editRegion(Integer id, RegionDto regionDto) {
        Optional<Region> optionalRegion = regionRepository.findById(id);
        if (optionalRegion.isEmpty()) {
           return new Result("Region is not found",false);
        }
        Region region = optionalRegion.get();
        region.setName(regionDto.getName());
        regionRepository.save(region);
        return new Result("Region is edited",true);
    }

    @Override
    public Result deleteRegion(Integer id) {
        regionRepository.deleteById(id);
        return new Result("Region is deleted",true);
    }
}
