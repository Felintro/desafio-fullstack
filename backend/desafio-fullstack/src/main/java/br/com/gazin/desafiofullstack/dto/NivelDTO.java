package br.com.gazin.desafiofullstack.dto;

import jakarta.validation.constraints.NotBlank;

public record NivelDTO(Integer id, @NotBlank(message = "O campo informado é vazio ou nulo!") String nivel) {

}