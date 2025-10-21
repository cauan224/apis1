package com.example.aula20.contrller;

import com.example.aula20.dto.ClienteRenposeDTO;
import com.example.aula20.dto.ClienteRequestDTO;
import com.example.aula20.model.ClienteModel;
import com.example.aula20.service.ClienteService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteControlller {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteRenposeDTO>> listar() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody ClienteRequestDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            String erros = result.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining(", "));
            return ResponseEntity.badRequest().body(Map.of("mensagem", erros, "sucesso", false));
        }

        clienteService.salvarCliente(dto);
        return ResponseEntity.ok(Map.of("mensagem", "Cliente cadastrado com sucesso", "sucesso", true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(@PathVariable Long id, @Valid @RequestBody ClienteRequestDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            String erros = result.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining(", "));
            return ResponseEntity.badRequest().body(Map.of("mensagem", erros, "sucesso", false));
        }

        clienteService.atualizarCliente(id, dto);
        return ResponseEntity.ok(Map.of("mensagem", "Cliente atualizado com sucesso", "sucesso", true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar(@PathVariable Long id) {
        clienteService.excluirCliente(id);
        return ResponseEntity.ok(Map.of("mensagem", "Cliente deletado com sucesso", "sucesso", true));
    }
}
