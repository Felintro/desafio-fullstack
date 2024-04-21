package br.com.gazin.desafiofullstack.service;

import br.com.gazin.desafiofullstack.dto.NivelDTO;
import br.com.gazin.desafiofullstack.model.Nivel;
import br.com.gazin.desafiofullstack.persistence.NivelRepository;
import br.com.gazin.desafiofullstack.utils.NivelMapper;
import jakarta.persistence.PersistenceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NivelService {

    private NivelRepository nivelRepository;

    public NivelService(NivelRepository nivelRepository) {
        this.nivelRepository = nivelRepository;
    }

    public List<NivelDTO> buscarTodos() {
        var nivelList = nivelRepository.findAll();
        var dtoList = NivelMapper.toDTOList(nivelList);
        return dtoList;
    }

    public NivelDTO cadastrar(NivelDTO nivelDTO) {
        var nivel = NivelMapper.toEntity(nivelDTO);
        nivelRepository.save(nivel);
        return NivelMapper.toDTO(nivel);
    }

    public NivelDTO atualizar(Integer id, NivelDTO nivelDTO) {
        var nivel = nivelRepository.findById(id).orElseThrow(PersistenceException::new);
        nivel.setNivel(nivelDTO.nivel());
        nivelRepository.save(nivel);
        return NivelMapper.toDTO(nivel);
    }

    public void deletarPorId(Integer id) {
        var nivel = nivelRepository.findById(id).orElseThrow(PersistenceException::new);
        nivelRepository.delete(nivel);
    }

}