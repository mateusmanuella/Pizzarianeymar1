package com.itbm.inf2fm.pizzarianeymar.model.entity;
import java.math.BigDecimal;
import jakarta.persistence.*;
@Entity
@jakarta.persistence.Table(name = "item_pedido")
public class ItemPedido {
 @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
 @Column(nullable = false) private int quantidade;
 @Column(name = "valor_unitario", nullable = false, precision = 10, scale = 2) private BigDecimal valorUnitario;
 @ManyToOne(optional = false) @JoinColumn(name = "pedido_id") private Pedido pedido;
 @ManyToOne(optional = false) @JoinColumn(name = "produto_id") private Produto produto;
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public int getQuantidade(){return quantidade;} public void setQuantidade(int quantidade){this.quantidade=quantidade;}
 public BigDecimal getValorUnitario(){return valorUnitario;} public void setValorUnitario(BigDecimal valorUnitario){this.valorUnitario=valorUnitario;}
 public Pedido getPedido(){return pedido;} public void setPedido(Pedido pedido){this.pedido=pedido;}
 public Produto getProduto(){return produto;} public void setProduto(Produto produto){this.produto=produto;}
}
