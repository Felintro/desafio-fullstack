package br.com.gazin.desafiofullstack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CadastrarDesenvolvedorDTO(@NotNull Integer nivelId, @NotBlank String nome, @NotNull char sexo, @NotNull LocalDate dataNascimento, @NotNull Integer idade, @NotBlank String hobby) {

}