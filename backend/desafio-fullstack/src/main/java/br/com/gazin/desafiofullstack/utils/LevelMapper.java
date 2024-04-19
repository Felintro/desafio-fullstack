package br.com.gazin.desafiofullstack.utils;

import br.com.gazin.desafiofullstack.dto.LevelDTO;
import br.com.gazin.desafiofullstack.model.Level;

import java.util.ArrayList;
import java.util.List;

public class LevelMapper {

    static Level toEntity(LevelDTO levelDTO) {
        return new Level(levelDTO.id(), levelDTO.level());
    }

    static LevelDTO toDTO(Level level) {
        return new LevelDTO(level.getId(), level.getLevel());
    }

    public static List<LevelDTO> toDTOList(List<Level> levelList) {
        List<LevelDTO> dtoList = new ArrayList<>();
        levelList.forEach(level -> dtoList.add(toDTO(level)));
        return dtoList;
    }

}