package com.itbm.inf2fm.pizzarianeymar.model.services;

import com.itbm.inf2fm.pizzarianeymar.model.entity.Categoria;
import com.itbm.inf2fm.pizzarianeymar.model.repository.CategoriaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }
}
