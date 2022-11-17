package py.com.utic.service;

import py.com.utic.entity.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    void save(Brand brand);
    List<Brand> getAll();
    Optional<Brand> getById(Long idBrand);
    void deleteById(Long idBrand);
}
