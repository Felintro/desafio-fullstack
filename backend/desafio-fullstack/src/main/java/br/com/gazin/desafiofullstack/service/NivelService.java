package br.com.gazin.desafiofullstack.service;

import br.com.gazin.desafiofullstack.dto.NivelDTO;
import br.com.gazin.desafiofullstack.persistence.NivelRepository;
import br.com.gazin.desafiofullstack.utils.NivelMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NivelService {

    private final String NIVEL_NAO_ENCONTRADO = "O nível não foi encontrado! ID: ";
    private final String DESENVOLVEDORES_ASSOCIADOS = "Existem desenvolvedores associados a este nível! ID: ";

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
        var nivel = nivelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(NIVEL_NAO_ENCONTRADO + id));
        nivel.setNivel(nivelDTO.nivel());
        nivelRepository.save(nivel);
        return NivelMapper.toDTO(nivel);
    }

    public void deletarPorId(Integer id) {
        try {
            var nivel = nivelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(NIVEL_NAO_ENCONTRADO + id));
            nivelRepository.delete(nivel);
        } catch(EntityNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());
        } catch(DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(DESENVOLVEDORES_ASSOCIADOS + id);
        }
    }

}