package py.com.utic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import py.com.utic.entity.Brand;
import py.com.utic.service.BrandService;
import py.com.utic.utils.ImageFinder;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class BrandController {

    @Autowired
    private BrandService service;

    @GetMapping("/utic/brand")
    public List<Brand> getAll() {
        return service.getAll();
    }

    @GetMapping("/utic/brand/{id}")
    public Optional<Brand> getById(@PathVariable("id") String idBrand) {
        return service.getById(Long.parseLong(idBrand));
    }

    @PostMapping("/utic/brand")
    public void save(@RequestBody Brand brand) {
        ImageFinder finder= new ImageFinder();
        brand.setImage(finder.getImageUrl(brand.getName(), ""));
        service.save(brand);
    }

    @DeleteMapping("utic/brand/{id}")
    public void deleteById(@PathVariable("id") String idBrand) {
        service.deleteById(Long.parseLong(idBrand));
    }

}
