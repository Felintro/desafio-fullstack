package br.com.gazin.desafiofullstack.service;

import br.com.gazin.desafiofullstack.dto.NivelDTO;
import br.com.gazin.desafiofullstack.model.Nivel;
import br.com.gazin.desafiofullstack.persistence.NivelRepository;
import br.com.gazin.desafiofullstack.utils.NivelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NivelService {

    private NivelRepository nivelRepository;

    public NivelService(NivelRepository nivelRepository) {
        this.nivelRepository = nivelRepository;
    }

    public List<NivelDTO> buscarTodos() {
        List<Nivel> nivelList = nivelRepository.findAll();
        List<NivelDTO> dtoList = NivelMapper.toDTOList(nivelList);
        return dtoList;
    }

}