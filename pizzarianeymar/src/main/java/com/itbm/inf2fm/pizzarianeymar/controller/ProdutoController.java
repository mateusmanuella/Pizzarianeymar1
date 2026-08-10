package com.itbm.inf2fm.pizzarianeymar.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbm.inf2fm.pizzarianeymar.model.entity.Produto;
import com.itbm.inf2fm.pizzarianeymar.model.services.ProdutoService;



//ANOTAÇÕES PARA A CLASSE dependência necessária -> spring-boot-starter-webmvc

// @Controller: Sistema Web ( Sites em Geral ) - Back-End + Front-End 
// @RestController: Api - Apenas Back-End

//ANOTAÇÕES PARA MÉTODOS dependência necessária -> spring-boot-starter-webmvc

// @GetMapping Utiliado para "buscar" dados na API (Somente pesquisa)
// @PostMapping Utilizado para "enviar" dados para API
// @PutMapping Utilizado para "atualizar" todos os dados na API 
// @Delete Utilizado para "excluir" dados na API
// @PatchMapping Utilizado para "atualizar parcialmente" dados na API, exemplo mudar o status de um produto 

//ResponseEntity: Controla a resposta HTTP

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    //Ligando meu controlador com o respectivo serviço
    private ProdutoService  produtoService = new ProdutoService();

    @GetMapping
    public ResponseEntity <List<Produto>> listarTodosProdutos (){

        return ResponseEntity.ok().body(produtoService.listarTodos());
    }

}
