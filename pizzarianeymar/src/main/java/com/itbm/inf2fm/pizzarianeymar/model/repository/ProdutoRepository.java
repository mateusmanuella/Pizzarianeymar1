package com.itbm.inf2fm.pizzarianeymar.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.itbm.inf2fm.pizzarianeymar.model.entity.Produto;
public interface ProdutoRepository extends JpaRepository<Produto, Long> { }
