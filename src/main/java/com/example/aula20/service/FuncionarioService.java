package com.example.aula20.service;

import com.example.aula20.dto.FuncionarioRequestDTO;
import com.example.aula20.dto.FuncionarioResponseDTO;
import com.example.aula20.model.FuncionarioModel;
import com.example.aula20.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public FuncionarioModel salvarFuncionario(FuncionarioRequestDTO requestDTO){
        if (funcionarioRepository.findByEmail(requestDTO.getEmail()).isPresent()){
            throw new IllegalArgumentException("E-mail já cadastrato");


        }
        FuncionarioModel funcionarioModel=new FuncionarioModel();
        funcionarioModel.setEmail(requestDTO.getEmail());
        funcionarioModel.setNome(requestDTO.getNome());
        funcionarioModel.setSenha(bCryptPasswordEncoder.encode(requestDTO.getEmail()));

        funcionarioRepository.save(funcionarioModel);
        return funcionarioModel;
    }
    public FuncionarioModel atualizarFuncionario(Long id, FuncionarioRequestDTO requestDTO){
        if (funcionarioRepository.existsById(id)){
            throw new IllegalArgumentException("Dados atualizado");


        }
        FuncionarioModel atulizarFuncionario=new FuncionarioModel();
        atulizarFuncionario.setEmail(requestDTO.getEmail());
        atulizarFuncionario.setNome(requestDTO.getNome());
        atulizarFuncionario.setSenha(bCryptPasswordEncoder.encode(requestDTO.getEmail()));

        funcionarioRepository.save(atulizarFuncionario);
        return atulizarFuncionario;
    }

    public  void excluirFuncionario(Long id){
        if (!funcionarioRepository.existsById(id)){
            throw new RuntimeException("Funcionario não econtrado");

        }
        funcionarioRepository.deleteById(id);
    }
    public List<FuncionarioResponseDTO>listTodos(){
        return funcionarioRepository
                .findAll()
                .stream()
                .map(u -> new FuncionarioResponseDTO(u.getNome(),u.getEmail()))
                .toList();
    }

}
