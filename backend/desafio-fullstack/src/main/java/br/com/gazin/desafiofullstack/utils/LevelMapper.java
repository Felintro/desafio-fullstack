package br.com.gazin.desafiofullstack.utils;

import br.com.gazin.desafiofullstack.dto.LevelDTO;
import br.com.gazin.desafiofullstack.model.Level;

public class LevelMapper {

    static Level toEntity(LevelDTO levelDTO) {
        return new Level(levelDTO.id(), levelDTO.level());
    }

    static LevelDTO toDTO(Level level) {
        return new LevelDTO(level.getId(), level.getLevel());
    }

}