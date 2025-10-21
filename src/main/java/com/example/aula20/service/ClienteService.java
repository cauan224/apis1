package com.example.aula20.service;

import com.example.aula20.dto.ClienteRequestDTO;
import com.example.aula20.dto.ClienteRenposeDTO;
import com.example.aula20.model.ClienteModel;
import com.example.aula20.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Cadastrar novo cliente
    public ClienteModel salvarCliente(ClienteRequestDTO requestDTO) {
        if (clienteRepository.findByEmail(requestDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("E-mail já cadastrado.");
        }

        ClienteModel cliente = new ClienteModel();
        cliente.setNome(requestDTO.getNome());
        cliente.setEmail(requestDTO.getEmail());
        cliente.setTelefone(requestDTO.getTelefone());
        cliente.setFormaPagamento(requestDTO.getFormaPagamento());
        cliente.setEndereco(requestDTO.getEndereco());

        return clienteRepository.save(cliente);
    }

    // Atualizar cliente
    public ClienteModel atualizarCliente(Long id, ClienteRequestDTO requestDTO) {
        ClienteModel cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));

        cliente.setNome(requestDTO.getNome());
        cliente.setEmail(requestDTO.getEmail());
        cliente.setTelefone(requestDTO.getTelefone());
        cliente.setFormaPagamento(requestDTO.getFormaPagamento());
        cliente.setEndereco(requestDTO.getEndereco());

        return clienteRepository.save(cliente);
    }

    // Excluir cliente
    public void excluirCliente(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado.");
        }
        clienteRepository.deleteById(id);
    }

    // Listar todos os clientes
    public List<ClienteRenposeDTO> listarTodos() {
        return clienteRepository.findAll().stream()
                .map(c -> new ClienteRenposeDTO(
                        c.getNome(),
                        c.getEmail(),
                        c.getTelefone(),
                        c.getFormaPagamento(),
                        c.getEndereco()
                ))
                .toList();
    }
}
