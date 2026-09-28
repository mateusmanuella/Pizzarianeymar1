 package com.itbm.inf2fm.pizzarianeymar.model.entity;
import java.time.LocalDateTime;
import jakarta.persistence.*;
@Entity
@jakarta.persistence.Table(name = "pedido")
public class Pedido {
 @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
 @Column(name = "data_pedido", nullable = false) private LocalDateTime dataPedido;
 @Column(nullable = false, length = 30) private String status;
 @ManyToOne(optional = false) @JoinColumn(name = "usuario_id") private Usuario usuario;
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public LocalDateTime getDataPedido(){return dataPedido;} public void setDataPedido(LocalDateTime dataPedido){this.dataPedido=dataPedido;}
 public String getStatus(){return status;} public void setStatus(String status){this.status=status;}
 public Usuario getUsuario(){return usuario;} public void setUsuario(Usuario usuario){this.usuario=usuario;}
}
