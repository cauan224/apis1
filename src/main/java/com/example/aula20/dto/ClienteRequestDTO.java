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
    @NotBlank (message = "o nome é obrigadorio.")
    @Size (min = 3,message = "O nome tem que ter no minimo 3 caracteres.")
    @Size (max = 200,message = "O nome não deve ter mais que 200 caracteres.")
    private String nome;

    @NotBlank (message = "O email é obrigadorio.")
    @Email(message = "deve ser um email valadido")
    @Size(min = 10,message = "O E-emali nao deve ter mais de 10")
    @Size(max = 200,message = "O e-email nao deve ter mais de 200 caracteres.")
    private String email;

    @NotBlank(message = "o numero é obrigadorio.")
    @Size (min = 12,message = "O nome tem quer ter minimi 3 caracteres")
    private String telefone;

    @NotBlank(message = "A Forma de pagamento é obrigadotia.")
    @Size (min = 3,message = "O nome tem que ter no minimo 3 caracteres.")
    private String formaPagamento;

    @NotBlank(message = "O endereco é obrigadotia.")
    @Size (max = 100,message = "O nome tem que ter no maximo 3 caracteres.")
    @Size(min = 10,message = "O minimo de 10")
    private String endereco;

}
