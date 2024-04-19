package br.com.gazin.desafiofullstack.dto;

import java.time.LocalDate;

public record DesenvolvedorDTO(Integer id, Integer nivelId, String nome, LocalDate dataNascimento, Integer idade, String hobby)  {

}