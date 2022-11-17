package py.com.utic.repository;

import org.springframework.data.repository.CrudRepository;
import py.com.utic.entity.Model;

public interface ModelRepository extends CrudRepository<Model, Long> {
}
