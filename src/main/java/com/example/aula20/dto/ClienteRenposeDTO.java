package com.example.aula20.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteRenposeDTO {
    private String nome;
    private String email;
    private String telefone;
    private String formaPagamento;
    private String endereco;

}
