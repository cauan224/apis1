package com.example.aula20.contrller;

import com.example.aula20.dto.ClienteRenposeDTO;
import com.example.aula20.dto.ClienteRequestDTO;
import com.example.aula20.dto.ClienteRenposeDTO;
import com.example.aula20.model.ClienteModel;
import com.example.aula20.service.ClienteService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteControlller {

    @Autowired
    private ClienteService clienteService;

    // POST - Cadastrar novo cliente
    @PostMapping
    public ResponseEntity<ClienteModel> cadastrarCliente(@RequestBody @Valid ClienteRequestDTO requestDTO) {
        ClienteModel novoCliente = clienteService.salvarCliente(requestDTO);
        return ResponseEntity.ok(novoCliente);
    }

    // PUT - Atualizar cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> atualizarCliente(@PathVariable Long id,
                                                         @RequestBody @Valid ClienteRequestDTO requestDTO) {
        ClienteModel clienteAtualizado = clienteService.atualizarCliente(id, requestDTO);
        return ResponseEntity.ok(clienteAtualizado);
    }

    // DELETE - Excluir cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
        clienteService.excluirCliente(id);
        return ResponseEntity.noContent().build();
    }

    // GET - Listar todos os clientes
    @GetMapping
    public ResponseEntity<List<ClienteRenposeDTO>> listarClientes() {
        List<ClienteRenposeDTO> lista = clienteService.listarTodos();
        return ResponseEntity.ok(lista);
    }
}
