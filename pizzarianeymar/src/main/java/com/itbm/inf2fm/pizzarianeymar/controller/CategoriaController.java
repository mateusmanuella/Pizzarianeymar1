package com.itbm.inf2fm.pizzarianeymar.controller;

import com.itbm.inf2fm.pizzarianeymar.model.entity.Categoria;
import com.itbm.inf2fm.pizzarianeymar.model.services.CategoriaService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarTodasCategorias() {
        return ResponseEntity.ok(categoriaService.listarTodas());
    }
}
