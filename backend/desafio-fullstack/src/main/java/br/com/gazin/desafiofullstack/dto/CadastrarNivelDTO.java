package br.com.gazin.desafiofullstack.dto;

import jakarta.validation.constraints.NotBlank;

public record CadastrarNivelDTO(@NotBlank String nivel) {

}
