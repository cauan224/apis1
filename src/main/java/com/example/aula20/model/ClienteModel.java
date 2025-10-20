package com.example.aula20.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "tab_Cliente")
public class ClienteModel {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false,length = 200)
    private String nome;
    @Column (nullable = false,unique = true)
    private String email;
    @Column (nullable = false,length = 200)
    private String telefone;
    @Column (nullable = false,length = 200)
    private String formaPagamento;
    @Column (nullable = false,length = 200)
    private String endereco;


}
