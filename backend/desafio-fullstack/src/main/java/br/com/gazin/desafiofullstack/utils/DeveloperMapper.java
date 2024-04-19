package br.com.gazin.desafiofullstack.utils;

import br.com.gazin.desafiofullstack.dto.DeveloperDTO;
import br.com.gazin.desafiofullstack.dto.LevelDTO;
import br.com.gazin.desafiofullstack.model.Developer;
import br.com.gazin.desafiofullstack.model.Level;

public class DeveloperMapper {

    static Developer toEntity(DeveloperDTO developerDTO) {
        Level level = LevelMapper.toEntity(developerDTO.levelDTO());
        return new Developer(null, level, developerDTO.name(), developerDTO.birthdate(), developerDTO.age(), developerDTO.hobby());
    }

    static DeveloperDTO toDTO(Developer developer) {
        LevelDTO levelDTO = LevelMapper.toDTO(developer.getLevel());
        return new DeveloperDTO(developer.getId(), levelDTO, developer.getName(), developer.getBirthdate(), developer.getAge(), developer.getHobby());
    }

}