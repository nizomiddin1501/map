package uz.developers.map.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.map.entity.Addresss;
import uz.developers.map.payload.AddressDto;
import uz.developers.map.payload.Result;
import uz.developers.map.repository.AddresssRepository;
import uz.developers.map.service.AddressService;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddresssRepository addresssRepository;

    @Override
    public List<Addresss> getAddresses() {
       return addresssRepository.findAll();
    }

    @Override
    public Addresss getAddress(Integer id) {
        Optional<Addresss> optionalAddresss = addresssRepository.findById(id);
        if (optionalAddresss.isPresent()) {
           return optionalAddresss.get();
        }
        return null;
    }

    @Override
    public Result addAddress(AddressDto addressDto) {
        Addresss addresss = new Addresss();
        addresss.setStreet(addressDto.getStreet());
        addresss.setHomeNumber(addressDto.getHomeNumber());
        addresssRepository.save(addresss);
        return new Result("Address is saved",true);
    }

    @Override
    public Result editAddress(Integer id, AddressDto addressDto) {
        Optional<Addresss> optionalAddresss = addresssRepository.findById(id);
        if (optionalAddresss.isEmpty()) {
            return new Result("Address is not found",true);
        }
        Addresss addresss = optionalAddresss.get();
        addresss.setStreet(addressDto.getStreet());
        addresss.setHomeNumber(addressDto.getHomeNumber());
        addresssRepository.save(addresss);
        return new Result("Address is saved",true);

    }

    @Override
    public Result deleteAddress(Integer id) {
        addresssRepository.deleteById(id);
        return new Result("Address is deleted",true);
    }
}
