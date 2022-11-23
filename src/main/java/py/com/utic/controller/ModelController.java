package py.com.utic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import py.com.utic.entity.Brand;
import py.com.utic.entity.Model;
import py.com.utic.service.BrandService;
import py.com.utic.service.ModelService;
import py.com.utic.utils.ImageFinder;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ModelController {

    @Autowired
    private ModelService service;

    @Autowired
    private BrandService brandService;


    @GetMapping("/utic/model")
    public List<Model> getAll(){
        return service.getAll();
    }

    @GetMapping("utic/model/{id}")
    public Optional<Model> findById(@PathVariable String id){
        return service.getById(Long.parseLong(id));
    }

    @PostMapping("utic/model")
    public void save(@RequestBody Model model){
        ImageFinder finder = new ImageFinder();
        Optional<Brand> brand= brandService.getById(Long.valueOf(model.getIdBrand()));
        model.setImage(finder.getImageUrl(brand.get().getName(),model.getName()));
        service.save(model);
    }

    @DeleteMapping("utic/model/{id}")
    public void delete(@PathVariable String id){
        service.deleteById(Long.parseLong(id));
    }
}
