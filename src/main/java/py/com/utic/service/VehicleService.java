package py.com.utic.service;

import py.com.utic.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    void save(Vehicle vehicle);
    List<Vehicle> getAll();
    Optional<Vehicle> getById(Long idVehicle);
    void deleteById(Long idVehicle);
}
