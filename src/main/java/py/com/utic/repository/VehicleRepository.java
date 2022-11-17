package py.com.utic.repository;

import org.springframework.data.repository.CrudRepository;
import py.com.utic.entity.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
}
