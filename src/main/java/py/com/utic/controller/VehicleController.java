package py.com.utic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import py.com.utic.entity.Vehicle;
import py.com.utic.service.VehicleService;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class VehicleController {

    @Autowired
    private VehicleService service;

    @GetMapping("utic/vehicle")
    public List<Vehicle> getAll(){
        return service.getAll();
    }

    @GetMapping("utic/vechicle/{id}")
    public Optional<Vehicle> getById(@PathVariable String id){
        return service.getById(Long.parseLong(id));
    }

    @PostMapping("utic/vehicle")
    public void save(@RequestBody Vehicle vehicle){
        service.save(vehicle);
    }

    @DeleteMapping("utic/vehicle/{id}")
    public void deleteById(@PathVariable String id){
        service.deleteById(Long.parseLong(id));
    }
}
