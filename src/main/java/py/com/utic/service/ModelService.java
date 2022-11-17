package py.com.utic.service;

import py.com.utic.entity.Model;

import java.util.List;
import java.util.Optional;

public interface ModelService {
    void save(Model model);
    List<Model> getAll();
    Optional<Model> getById(Long idModel);
    void deleteById(Long idModel);
}
