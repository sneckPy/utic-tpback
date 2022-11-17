package py.com.utic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import py.com.utic.entity.Brand;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {
}
