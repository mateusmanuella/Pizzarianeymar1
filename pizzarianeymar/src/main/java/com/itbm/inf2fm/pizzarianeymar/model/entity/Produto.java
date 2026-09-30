package com.itbm.inf2fm.pizzarianeymar.model.entity;

import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@jakarta.persistence.Table(name = "produto")
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false, length = 100) private String nome;
    @Column(length = 255) private String descricao;
    @Column(name = "valor_compra", precision = 10, scale = 2) private BigDecimal valorCompra;
    @Column(name = "valor_venda", nullable = false, precision = 10, scale = 2) private BigDecimal valorVenda;
    @Column(name = "quantidade_estoque", nullable = false) private int quantidadeEstoque;
    @Column(name = "cod_status", nullable = false) private boolean codStatus = true;
    @ManyToOne @JoinColumn(name = "categoria_id") private Categoria categoria;
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; } public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; } public void setDescricao(String descricao) { this.descricao = descricao; }
    public BigDecimal getValorCompra() { return valorCompra; } public void setValorCompra(BigDecimal valorCompra) { this.valorCompra = valorCompra; }
    public BigDecimal getValorVenda() { return valorVenda; } public void setValorVenda(BigDecimal valorVenda) { this.valorVenda = valorVenda; }
    public int getQuantidadeEstoque() { return quantidadeEstoque; } public void setQuantidadeEstoque(int quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }
    public boolean isCodStatus() { return codStatus; } public void setCodStatus(boolean codStatus) { this.codStatus = codStatus; }
    public Categoria getCategoria() { return categoria; } public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public Object getTipo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTipo'");
    }
}
