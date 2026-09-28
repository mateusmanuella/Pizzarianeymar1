package com.itbm.inf2fm.pizzarianeymar.model.services;
import java.util.List;
import org.springframework.stereotype.Service;
import com.itbm.inf2fm.pizzarianeymar.model.entity.Produto;
import com.itbm.inf2fm.pizzarianeymar.model.repository.ProdutoRepository;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    public ProdutoService(ProdutoRepository produtoRepository) { this.produtoRepository = produtoRepository; }
    public List<Produto> listarTodos() { return produtoRepository.findAll(); }
    public Produto buscarPorId(Long id) { return produtoRepository.findById(id).orElse(null); }
    public Produto salvar(Produto produto) { produto.setId(null); return produtoRepository.save(produto); }
    public Produto atualizar(Long id, Produto produto) { if (!produtoRepository.existsById(id)) return null; produto.setId(id); return produtoRepository.save(produto); }
    public boolean excluir(Long id) { if (!produtoRepository.existsById(id)) return false; produtoRepository.deleteById(id); return true; }
}
