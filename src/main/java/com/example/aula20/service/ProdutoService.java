package com.example.aula20.service;

import com.example.aula20.dto.ProdutoRequestDTO;
import com.example.aula20.dto.ProdutoResponseDTO;
import com.example.aula20.model.ProdutoModel;
import com.example.aula20.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Cadastrar novo produto
    public ProdutoModel salvarProduto(ProdutoRequestDTO requestDTO) {
        if (produtoRepository.findByLote(requestDTO.getLote()).isPresent()) {
            throw new IllegalArgumentException("Lote já cadastrado.");
        }

        ProdutoModel produto = new ProdutoModel();
        produto.setNome(requestDTO.getNome());
        produto.setLote(requestDTO.getLote());
        produto.setValidade(requestDTO.getValidae());
        produto.setCategoria(requestDTO.getCategoria());
        produto.setQuantidade(requestDTO.getQuantidade());

        return produtoRepository.save(produto);
    }

    // Atualizar produto existente
    public ProdutoModel atualizarProduto(Long id, ProdutoRequestDTO requestDTO) {
        ProdutoModel produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado."));

        produto.setNome(requestDTO.getNome());
        produto.setLote(requestDTO.getLote());
        produto.setValidade(requestDTO.getValidae());
        produto.setCategoria(requestDTO.getCategoria());
        produto.setQuantidade(requestDTO.getQuantidade());

        return produtoRepository.save(produto);
    }

    // Excluir produto
    public void excluirProduto(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado.");
        }
        produtoRepository.deleteById(id);
    }

    // Listar todos os produtos (DTO de resposta)
    public List<ProdutoResponseDTO> listarTodos() {
        return produtoRepository.findAll().stream()
                .map(produto -> new ProdutoResponseDTO(
                        produto.getNome(),
                        produto.getLote(),
                        produto.getValidade(),
                        produto.getCategoria(),
                        produto.getQuantidade()
                ))
                .toList();
    }
}
