package br.com.gazin.desafiofullstack.dto;

import jakarta.validation.constraints.NotBlank;

public record NivelDTO(Integer id, @NotBlank String nivel) {

}