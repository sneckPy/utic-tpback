package py.com.utic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.utic.entity.Model;
import py.com.utic.repository.ModelRepository;
import py.com.utic.service.ModelService;

import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    ModelRepository repository;

    @Override
    public void save(Model model) {
        repository.save(model);
    }

    @Override
    public List<Model> getAll() {
        return (List) repository.findAll();
    }

    @Override
    public Optional<Model> getById(Long idModel) {
        return repository.findById(idModel);
    }

    @Override
    public void deleteById(Long idModel) {
        repository.deleteById(idModel);
    }
}
