package com.example.aula20.contrller;

import com.example.aula20.dto.ProdutoRequestDTO;
import com.example.aula20.dto.ProdutoResponseDTO;
import com.example.aula20.model.ProdutoModel;
import com.example.aula20.service.ProdutoService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // POST - Cadastrar novo produto
    @PostMapping
    public ResponseEntity<ProdutoModel> cadastrarProduto(@RequestBody @Valid ProdutoRequestDTO requestDTO) {
        ProdutoModel novoProduto = produtoService.salvarProduto(requestDTO);
        return ResponseEntity.ok(novoProduto);
    }

    // PUT - Atualizar produto
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModel> atualizarProduto(@PathVariable Long id,
                                                         @RequestBody @Valid ProdutoRequestDTO requestDTO) {
        ProdutoModel produtoAtualizado = produtoService.atualizarProduto(id, requestDTO);
        return ResponseEntity.ok(produtoAtualizado);
    }

    // DELETE - Excluir produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {
        produtoService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }

    // GET - Listar todos os produtos
    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listarProdutos() {
        List<ProdutoResponseDTO> produtos = produtoService.listarTodos();
        return ResponseEntity.ok(produtos);
    }
}
