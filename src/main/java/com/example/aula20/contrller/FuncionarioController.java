package com.example.aula20.contrller;

import com.example.aula20.dto.FuncionarioRequestDTO;
import com.example.aula20.dto.FuncionarioResponseDTO;
import com.example.aula20.model.FuncionarioModel;
import com.example.aula20.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;
    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDTO>>listar(){
        return ResponseEntity
                .ok()
                .body(funcionarioService.listTodos());
    }
    @PostMapping
    public ResponseEntity <Map<String, Object>>salvar(@Valid @RequestBody FuncionarioRequestDTO dto){
        FuncionarioModel funcionarioModel = funcionarioService.salvarFuncionario(dto);

        return ResponseEntity
                .created(null)
                .body(Map.of("mensagem","Funcionario Cadastrado com sucesso","sucesso",true));
    }
    @PutMapping ("/{id}")
    public ResponseEntity <Map<String, Object>>atualizar(@PathVariable Long id,@Valid @RequestBody FuncionarioRequestDTO dto){
        FuncionarioModel funcionarioModel = funcionarioService.atualizarFuncionario(id,dto);

        return ResponseEntity
                .created(null)
                .body(Map.of("mensagem","Funcionario Atualizado","sucesso",true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Map<String, Object>>deletar(@PathVariable Long id){
         funcionarioService.excluirFuncionario(id);
        return ResponseEntity
                .created(null)
                .body(Map.of("mensagem","Funcionario deletando com sucesso","sucesso",true));
    }

}
