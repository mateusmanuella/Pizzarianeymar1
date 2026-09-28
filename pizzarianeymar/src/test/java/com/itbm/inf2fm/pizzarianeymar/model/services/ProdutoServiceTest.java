package com.itbm.inf2fm.pizzarianeymar.model.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.itbm.inf2fm.pizzarianeymar.model.entity.Produto;
import com.itbm.inf2fm.pizzarianeymar.model.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {
    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    @Test
    void listarTodosRetornaProdutosDoRepository() {
        Produto produto = new Produto();
        when(produtoRepository.findAll()).thenReturn(List.of(produto));

        List<Produto> produtos = produtoService.listarTodos();

        assertEquals(List.of(produto), produtos);
    }

    @Test
    void buscarPorIdRetornaProdutoQuandoExiste() {
        Produto produto = new Produto();
        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));

        Produto encontrado = produtoService.buscarPorId(1L);

        assertSame(produto, encontrado);
    }

    @Test
    void buscarPorIdRetornaNullQuandoNaoExiste() {
        when(produtoRepository.findById(1L)).thenReturn(Optional.empty());

        Produto encontrado = produtoService.buscarPorId(1L);

        assertNull(encontrado);
    }

    @Test
    void salvarRemoveIdAntesDePersistir() {
        Produto produto = new Produto();
        produto.setId(10L);
        when(produtoRepository.save(produto)).thenReturn(produto);

        Produto salvo = produtoService.salvar(produto);

        assertNull(salvo.getId());
        verify(produtoRepository).save(produto);
    }

    @Test
    void atualizarSalvaComIdDaUrlQuandoProdutoExiste() {
        Produto produto = new Produto();
        when(produtoRepository.existsById(3L)).thenReturn(true);
        when(produtoRepository.save(produto)).thenReturn(produto);

        Produto atualizado = produtoService.atualizar(3L, produto);

        assertSame(produto, atualizado);
        assertEquals(3L, produto.getId());
        verify(produtoRepository).save(produto);
    }

    @Test
    void atualizarRetornaNullQuandoProdutoNaoExiste() {
        Produto produto = new Produto();
        when(produtoRepository.existsById(3L)).thenReturn(false);

        Produto atualizado = produtoService.atualizar(3L, produto);

        assertNull(atualizado);
        verify(produtoRepository, never()).save(produto);
    }

    @Test
    void excluirRemoveProdutoQuandoExiste() {
        when(produtoRepository.existsById(4L)).thenReturn(true);

        boolean excluido = produtoService.excluir(4L);

        assertTrue(excluido);
        verify(produtoRepository).deleteById(4L);
    }

    @Test
    void excluirRetornaFalseQuandoProdutoNaoExiste() {
        when(produtoRepository.existsById(4L)).thenReturn(false);

        boolean excluido = produtoService.excluir(4L);

        assertFalse(excluido);
        verify(produtoRepository, never()).deleteById(4L);
    }
}
