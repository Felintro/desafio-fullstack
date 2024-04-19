package br.com.gazin.desafiofullstack.utils;

import br.com.gazin.desafiofullstack.dto.NivelDTO;
import br.com.gazin.desafiofullstack.model.Nivel;

import java.util.ArrayList;
import java.util.List;

public class NivelMapper {

    static Nivel toEntity(NivelDTO nivelDTO) {
        return new Nivel(nivelDTO.id(), nivelDTO.nivel());
    }

    static NivelDTO toDTO(Nivel nivel) {
        return new NivelDTO(nivel.getId(), nivel.getNivel());
    }

    public static List<NivelDTO> toDTOList(List<Nivel> nivelList) {
        List<NivelDTO> dtoList = new ArrayList<>();
        nivelList.forEach(nivel -> dtoList.add(toDTO(nivel)));
        return dtoList;
    }

}