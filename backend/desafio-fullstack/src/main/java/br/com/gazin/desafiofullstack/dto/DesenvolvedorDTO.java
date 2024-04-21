package br.com.gazin.desafiofullstack.dto;

import java.time.LocalDate;

public record DesenvolvedorDTO(Integer id, NivelDTO nivelDTO, String nome, char sexo, LocalDate dataNascimento, Integer idade, String hobby)  {

}