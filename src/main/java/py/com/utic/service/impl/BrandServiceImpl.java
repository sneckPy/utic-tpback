package py.com.utic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.utic.entity.Brand;
import py.com.utic.repository.BrandRepository;
import py.com.utic.service.BrandService;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository repository;

    @Override
    public void save(Brand brand) {
        repository.save(brand);
    }

    @Override
    public List<Brand> getAll() {
        return (List) repository.findAll();
    }

    @Override
    public Optional<Brand> getById(Long idBrand) {
        return repository.findById(idBrand);
    }

    @Override
    public void deleteById(Long idBrand) {
        repository.deleteById(idBrand);
    }
}
