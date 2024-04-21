package br.com.gazin.desafiofullstack.utils;

import br.com.gazin.desafiofullstack.dto.DesenvolvedorDTO;
import br.com.gazin.desafiofullstack.model.Desenvolvedor;
import br.com.gazin.desafiofullstack.model.Nivel;

import java.util.ArrayList;
import java.util.List;

public class DesenvolvedorMapper {

    public static Desenvolvedor toEntity(DesenvolvedorDTO desenvolvedorDTO) {
        return new Desenvolvedor(null, new Nivel(desenvolvedorDTO.nivelId(), null), desenvolvedorDTO.nome(), desenvolvedorDTO.dataNascimento(), desenvolvedorDTO.idade(), desenvolvedorDTO.hobby());
    }

    public static DesenvolvedorDTO toDTO(Desenvolvedor desenvolvedor) {
        return new DesenvolvedorDTO(desenvolvedor.getId(), desenvolvedor.getNivel().getId(), desenvolvedor.getNome(), desenvolvedor.getDataNascimento(), desenvolvedor.getIdade(), desenvolvedor.getHobby());
    }

    public static List<DesenvolvedorDTO> toDTOList(List<Desenvolvedor> desenvolvedorList) {
        List<DesenvolvedorDTO> dtoList = new ArrayList<>();
        desenvolvedorList.forEach(desenvolvedor -> dtoList.add(toDTO(desenvolvedor)));
        return dtoList;
    }

}