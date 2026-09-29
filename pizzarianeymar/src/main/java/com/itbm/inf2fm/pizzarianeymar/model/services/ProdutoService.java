package com.itbm.inf2fm.pizzarianeymar.model.services;

import com.itbm.inf2fm.pizzarianeymar.model.entity.Produto;
import com.itbm.inf2fm.pizzarianeymar.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class ProdutoService {

    @Autowired // injeção de dependencia automatica
    private ProdutoRepository produtoRepository ;

    //metodo responsavel em listar todos os produtos cadastrados no banco dedados

    public List<Produto> findALL(){ return produtoRepository.findAll();}

    //metodo responsavel em criar o produto no banco de dados

    public Produto save (Produto produto){
        produto.setCodStatus(true);
        return produtoRepository.save(produto);
    }

    //metodo responsavel em listar o produto por id

    public Produto findById(Long id){
        return produtoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Produto não encontrado om o id" + id));
    }

    //metodo responsavel em atualizar o produto

    public Produto update(Long id, Produto produto)
        Produto produtoExistente = findById(id);
        produtoExistente.setDescricao(null);
}