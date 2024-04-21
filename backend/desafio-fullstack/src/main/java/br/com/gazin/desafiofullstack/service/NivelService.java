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

    public void deletarPorId(Integer id) {
        var nivel = nivelRepository.findById(id).orElseThrow(PersistenceException::new);
        nivelRepository.delete(nivel);
    }

    public NivelDTO cadastrar(String nomeNivel) {
        var nivel = new Nivel(null, nomeNivel);
        nivelRepository.save(nivel);
        return NivelMapper.toDTO(nivel);
    }

    public NivelDTO atualizar(Integer id, String novoNivel) {
        var nivel = nivelRepository.findById(id).orElseThrow(PersistenceException::new);
        nivel.setNivel(novoNivel);
        nivelRepository.save(nivel);
        return NivelMapper.toDTO(nivel);
    }
}