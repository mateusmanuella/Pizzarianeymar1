package com.itbm.inf2fm.pizzarianeymar.model.entity;

import jakarta.persistence.*;

@Entity
@jakarta.persistence.Table(name = "categoria")
public class Categoria {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false, length = 80) private String nome;
    @Column(length = 255) private String descricao;
    @Column(name = "cod_status", nullable = false) private boolean codStatus = true;
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; } public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; } public void setDescricao(String descricao) { this.descricao = descricao; }
    public boolean isCodStatus() { return codStatus; } public void setCodStatus(boolean codStatus) { this.codStatus = codStatus; }
}
