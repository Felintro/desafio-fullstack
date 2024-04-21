package br.com.gazin.desafiofullstack.utils;

import br.com.gazin.desafiofullstack.dto.CadastrarDesenvolvedorDTO;
import br.com.gazin.desafiofullstack.dto.DesenvolvedorDTO;
import br.com.gazin.desafiofullstack.model.Desenvolvedor;
import br.com.gazin.desafiofullstack.model.Nivel;

import java.util.ArrayList;
import java.util.List;

public class DesenvolvedorMapper {

    /* FIXME - Remover caso não for utilizar*/
    public static Desenvolvedor toEntity(DesenvolvedorDTO desenvolvedorDTO) {
        return new Desenvolvedor(desenvolvedorDTO.id(), NivelMapper.toEntity(desenvolvedorDTO.nivelDTO()), desenvolvedorDTO.nome(), desenvolvedorDTO.sexo(), desenvolvedorDTO.dataNascimento(), desenvolvedorDTO.idade(), desenvolvedorDTO.hobby());
    }

    public static Desenvolvedor toEntity(CadastrarDesenvolvedorDTO cadastrarDesenvolvedorDTO) {
        return new Desenvolvedor(null, new Nivel(cadastrarDesenvolvedorDTO.nivelId(), null), cadastrarDesenvolvedorDTO.nome(), cadastrarDesenvolvedorDTO.sexo(), cadastrarDesenvolvedorDTO.dataNascimento(), cadastrarDesenvolvedorDTO.idade(), cadastrarDesenvolvedorDTO.hobby());
    }

    public static DesenvolvedorDTO toDTO(Desenvolvedor desenvolvedor) {
        return new DesenvolvedorDTO(desenvolvedor.getId(), NivelMapper.toDTO(desenvolvedor.getNivel()), desenvolvedor.getNome(), desenvolvedor.getSexo(), desenvolvedor.getDataNascimento(), desenvolvedor.getIdade(), desenvolvedor.getHobby());
    }

    public static List<DesenvolvedorDTO> toDTOList(List<Desenvolvedor> desenvolvedorList) {
        List<DesenvolvedorDTO> dtoList = new ArrayList<>();
        desenvolvedorList.forEach(desenvolvedor -> dtoList.add(toDTO(desenvolvedor)));
        return dtoList;
    }

}