package uz.developers.map.service;

import uz.developers.map.entity.Addresss;
import uz.developers.map.payload.AddressDto;
import uz.developers.map.payload.Result;

import java.util.List;

public interface AddressService {
    List<Addresss> getAddresses();

    Addresss getAddress(Integer id);

    Result addAddress(AddressDto addressDto);

    Result editAddress(Integer id, AddressDto addressDto);

    Result deleteAddress(Integer id);
}
