package br.com.gazin.desafiofullstack.dto;

import java.time.LocalDate;

public record CadastrarDesenvolvedorDTO(Integer nivelId, String nome, char sexo, LocalDate dataNascimento, Integer idade, String hobby) {

}