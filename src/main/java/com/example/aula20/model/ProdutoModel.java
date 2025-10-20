package com.example.aula20.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tab_produto")
public class ProdutoModel {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String nome;
    @Column (nullable = false,unique = true)
    private String lote;
    @Column (nullable = false)
    private String validade;
    @Column (nullable = false)
    private String categoria;
    @Column (nullable = false)
    private int quantidade;
}
