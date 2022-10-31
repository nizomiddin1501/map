package uz.developers.map.service;

import uz.developers.map.entity.Region;
import uz.developers.map.payload.RegionDto;
import uz.developers.map.payload.Result;

import java.util.List;

public interface RegionService {
    List<Region> getRegions();

    Region getRegion(Integer id);

    Result addRegion(RegionDto regionDto);

    Result editRegion(Integer id, RegionDto regionDto);

    Result deleteRegion(Integer id);
}
