package com.itbm.inf2fm.pizzarianeymar.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.itbm.inf2fm.pizzarianeymar.model.entity.Usuario;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { }
