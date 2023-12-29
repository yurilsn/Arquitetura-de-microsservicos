package com.microsservico.gerenciamentodeanimais.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer dono;

    @Column
    private String nome;

    @Column
    private Integer idade;

    @Column
    private String raca;

    @Column
    private Boolean vivo;
}
