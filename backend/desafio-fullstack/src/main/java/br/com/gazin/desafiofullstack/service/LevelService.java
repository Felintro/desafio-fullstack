package br.com.gazin.desafiofullstack.service;

import br.com.gazin.desafiofullstack.dto.LevelDTO;
import br.com.gazin.desafiofullstack.model.Level;
import br.com.gazin.desafiofullstack.persistence.LevelRepository;
import br.com.gazin.desafiofullstack.utils.LevelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelService {

    private LevelRepository levelRepository;

    public LevelService(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    public List<LevelDTO> findAll() {
        List<Level> levelList = levelRepository.findAll();
        List<LevelDTO> dtoList = LevelMapper.toDTOList(levelList);
        return dtoList;
    }

}