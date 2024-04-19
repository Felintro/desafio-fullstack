package br.com.gazin.desafiofullstack.dto;

import java.time.LocalDate;

public record DeveloperDTO(Integer id, LevelDTO levelDTO, String name, LocalDate birthdate, Integer age, String hobby)  {

}