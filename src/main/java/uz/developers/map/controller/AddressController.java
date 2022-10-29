package uz.developers.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.jpa_relationships_tasks.task1.model.Mark;
import uz.developers.jpa_relationships_tasks.task1.payload.MarkDto;
import uz.developers.jpa_relationships_tasks.task1.repository.MarkRepository;
import uz.developers.jpa_relationships_tasks.task2.entity.Addresss;
import uz.developers.jpa_relationships_tasks.task2.payload.AddressDto;
import uz.developers.jpa_relationships_tasks.task2.repository.AddresssRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddresssRepository addresssRepository;


    @GetMapping
    public List<Addresss> getAddresss(){
        List<Addresss> addressses = addresssRepository.findAll();
        return addressses;
    }

    @PostMapping
    public String addAddresss(@RequestBody AddressDto addressDto){
        Addresss addresss = new Addresss();
        addresss.setStreet(addressDto.getStreet());
        addresss.setHomeNumber(addressDto.getHomeNumber());
        addresssRepository.save(addresss);
        return "Addresss is added";
    }

    @PutMapping("/{id}")
    public String editMark(@PathVariable Integer id,@RequestBody AddressDto addressDto){
        Optional<Addresss> optionalAddresss = addresssRepository.findById(id);
        if (optionalAddresss.isPresent()) {
            Addresss addresss = optionalAddresss.get();
            addresss.setStreet(addressDto.getStreet());
            addresss.setHomeNumber(addressDto.getHomeNumber());
            addresssRepository.save(addresss);
            return "Addresss is edited";
        }
        return "Addresss not found";
    }
    @DeleteMapping("/{id}")
    public String deleteAddresss(@PathVariable Integer id){
        addresssRepository.deleteById(id);
        return "Addresss is deleted";
    }

}
