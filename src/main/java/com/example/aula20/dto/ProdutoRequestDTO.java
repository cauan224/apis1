package com.example.aula20.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequestDTO {
    @NotBlank(message = "o nome é obrigadorio.")
    @Size(min = 3,message = "O nome tem que ter no minimo 3 caracteres.")
    @Size (max = 200,message = "O nome não deve ter mais que 200 caracteres.")
    private String nome;

    @NotBlank (message = "O lote é obrigatorio.")
    @Size(max = 200,message = "O lote nao deve ter mais de 200 caracteres.")
    private String lote;

    @NotBlank(message = "a validadde é obrigadorio.")
    @Size (min = 12,message = "a validade tem quer ter minimi 3 caracteres")
    private String validae;

    @NotBlank(message = "A categoria é obrigadotia.")
    @Size (min = 3,message = "A categoria tem que ter no minimo 3 caracteres.")
    private String categoria;

    @NotBlank(message = "A quantidade é obrigadotia.")
    @Size (max = 200,message = "A quantidade não deve ter mais que 200 caracteres.")
    private int quantidade;
}

