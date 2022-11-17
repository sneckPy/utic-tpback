package py.com.utic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import py.com.utic.entity.Model;
import py.com.utic.service.ModelService;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ModelController {

    @Autowired
    private ModelService service;

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
        service.save(model);
    }

    @DeleteMapping("utic/model/{id}")
    public void delete(@PathVariable String id){
        service.deleteById(Long.parseLong(id));
    }
}
