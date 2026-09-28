package com.itbm.inf2fm.pizzarianeymar.model.entity;
import jakarta.persistence.*;
@Entity
@jakarta.persistence.Table(name = "telefone")
public class Telefone {
 @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
 @Column(nullable = false, length = 20) private String numero;
 @ManyToOne(optional = false) @JoinColumn(name = "usuario_id") private Usuario usuario;
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getNumero(){return numero;} public void setNumero(String numero){this.numero=numero;}
 public Usuario getUsuario(){return usuario;} public void setUsuario(Usuario usuario){this.usuario=usuario;}
}
