package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotBlank
    String titulo;
    @NotBlank
    String diretor;
    @Min(1895)
    @Max(2022)
    Integer anoLancamento;
    @NotBlank
    @Column(columnDefinition = "text")
    String imagem;
    @NotBlank
    @Column(columnDefinition = "text")
    String sinopse;
    @Min(0)
    @Max(5)
    Float avaliacao;

}
