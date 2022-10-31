package uz.developers.map.service;

import uz.developers.map.entity.District;
import uz.developers.map.payload.DistrictDto;
import uz.developers.map.payload.Result;

import java.util.List;

public interface DistrictService {


    List<District> getDistricts();

    District getDistrict(Integer id);

    Result addDistrict(DistrictDto districtDto);

    Result editDistrict(Integer id, DistrictDto districtDto);

    Result deleteDistrict(Integer id);
}
