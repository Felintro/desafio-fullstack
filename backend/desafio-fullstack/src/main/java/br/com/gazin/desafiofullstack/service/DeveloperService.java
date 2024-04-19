package br.com.gazin.desafiofullstack.service;

import br.com.gazin.desafiofullstack.dto.DeveloperDTO;
import br.com.gazin.desafiofullstack.model.Developer;
import br.com.gazin.desafiofullstack.persistence.DeveloperRepository;
import br.com.gazin.desafiofullstack.utils.DeveloperMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperService {

    private DeveloperRepository developerRepository;

    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public List<DeveloperDTO> findAll() {
        List<Developer> developerList = developerRepository.findAll();
        List<DeveloperDTO> dtoList = DeveloperMapper.toDTOList(developerList);
        return dtoList;
    }

}