package py.com.utic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.utic.entity.Vehicle;
import py.com.utic.repository.VehicleRepository;
import py.com.utic.service.VehicleService;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;

    @Override
    public void save(Vehicle vehicle) {
        repository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAll() {
        return (List) repository.findAll();
    }

    @Override
    public Optional<Vehicle> getById(Long idVehicle) {
        return repository.findById(idVehicle);
    }

    @Override
    public void deleteById(Long idVehicle) {
        repository.deleteById(idVehicle);
    }
}
