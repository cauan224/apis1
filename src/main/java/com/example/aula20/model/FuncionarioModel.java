package com.example.aula20.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tab_funcionario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false,length = 200)
    private String nome;
    @Column(nullable = false,unique = true,length = 200)
    private String email;
    @Column (nullable = false,length = 200)
    private String senha;
}
