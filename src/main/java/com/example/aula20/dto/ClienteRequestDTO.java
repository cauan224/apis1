package com.example.aula20.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteRequestDTO {

    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 3, max = 200, message = "O nome deve ter entre 3 e 200 caracteres.")
    private String nome;

    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "Deve ser um email válido.")
    @Size(min = 10, max = 200, message = "O email deve ter entre 10 e 200 caracteres.")
    private String email;

    @NotBlank(message = "O telefone é obrigatório.")
    @Size(min = 10, max = 15, message = "O telefone deve ter entre 10 e 15 caracteres.")
    private String telefone;

    @NotBlank(message = "A forma de pagamento é obrigatória.")
    @Size(min = 3, max = 100, message = "A forma de pagamento deve ter entre 3 e 100 caracteres.")
    private String formaPagamento;

    @NotBlank(message = "O endereço é obrigatório.")
    @Size(min = 10, message = "O endereço deve ter entre 10 e 100 caracteres.")
    private String endereco;
}
