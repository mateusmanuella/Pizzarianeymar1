package com.itbm.inf2fm.pizzarianeymar.controller;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.itbm.inf2fm.pizzarianeymar.model.entity.Produto;
import com.itbm.inf2fm.pizzarianeymar.model.services.ProdutoService;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;
    public ProdutoController(ProdutoService produtoService) { this.produtoService = produtoService; }
    @GetMapping public ResponseEntity<List<Produto>> listarTodosProdutos() { return ResponseEntity.ok(produtoService.listarTodos()); }
    @GetMapping("/{id}") public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) { Produto produto = produtoService.buscarPorId(id); return produto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(produto); }
    @PostMapping public ResponseEntity<Produto> salvar(@RequestBody Produto produto) { return ResponseEntity.status(201).body(produtoService.salvar(produto)); }
    @PutMapping("/{id}") public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto) { Produto atualizado = produtoService.atualizar(id, produto); return atualizado == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(atualizado); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> excluir(@PathVariable Long id) { return produtoService.excluir(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build(); }
}
