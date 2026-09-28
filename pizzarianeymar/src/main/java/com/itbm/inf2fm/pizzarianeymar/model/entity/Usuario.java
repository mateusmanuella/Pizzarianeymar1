package com.itbm.inf2fm.pizzarianeymar.model.entity;

import com.itbm.inf2fm.pizzarianeymar.model.enums.TipoUsuario;
import jakarta.persistence.*;

@Entity
@jakarta.persistence.Table(name = "usuario")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false, length = 100) private String nome;
    @Column(nullable = false, unique = true, length = 14) private String cpf;
    @Column(nullable = false, unique = true, length = 120) private String email;
    @Column(nullable = false, length = 255) private String senha;
    @Column(length = 20) private String sexo;
    @Column(length = 150) private String logradouro;
    @Column(length = 9) private String cep;
    @Column(length = 80) private String bairro;
    @Column(length = 80) private String cidade;
    @Column(length = 2) private String uf;
    @Column(name = "cod_status", nullable = false) private boolean codStatus = true;
    @Enumerated(EnumType.STRING) @Column(name = "tipo_usuario", nullable = false, length = 20) private TipoUsuario tipoUsuario;
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; } public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; } public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEmail() { return email; } public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; } public void setSenha(String senha) { this.senha = senha; }
    public String getSexo() { return sexo; } public void setSexo(String sexo) { this.sexo = sexo; }
    public String getLogradouro() { return logradouro; } public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
    public String getCep() { return cep; } public void setCep(String cep) { this.cep = cep; }
    public String getBairro() { return bairro; } public void setBairro(String bairro) { this.bairro = bairro; }
    public String getCidade() { return cidade; } public void setCidade(String cidade) { this.cidade = cidade; }
    public String getUf() { return uf; } public void setUf(String uf) { this.uf = uf; }
    public boolean isCodStatus() { return codStatus; } public void setCodStatus(boolean codStatus) { this.codStatus = codStatus; }
    public TipoUsuario getTipoUsuario() { return tipoUsuario; } public void setTipoUsuario(TipoUsuario tipoUsuario) { this.tipoUsuario = tipoUsuario; }
}
