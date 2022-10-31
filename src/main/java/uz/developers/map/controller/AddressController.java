package uz.developers.map.controller;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.map.payload.AddressDto;
import uz.developers.map.entity.Addresss;
import uz.developers.map.payload.Result;
import uz.developers.map.service.AddressService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping
    public List<Addresss> getAddresses(){
        return addressService.getAddresses();
    }
    @GetMapping("/{id}")
    public Addresss getAddress(@PathVariable Integer id){
        return addressService.getAddress(id);
    }

    @PostMapping
    public Result addAddress(@RequestBody AddressDto addressDto){
        return addressService.addAddress(addressDto);
    }

    @PutMapping("/{id}")
    public Result editAddress(@PathVariable Integer id, @RequestBody AddressDto addressDto){
        return addressService.editAddress(id,addressDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteAddress(@PathVariable Integer id){
        return addressService.deleteAddress(id);
    }

}
