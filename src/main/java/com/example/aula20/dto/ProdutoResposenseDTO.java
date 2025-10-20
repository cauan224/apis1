package com.example.aula20.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ProdutoResposenseDTO {
    private String nome;
    private String lote;
    private String validade;
    private String categoria;
    private Integer quantidade;
}
