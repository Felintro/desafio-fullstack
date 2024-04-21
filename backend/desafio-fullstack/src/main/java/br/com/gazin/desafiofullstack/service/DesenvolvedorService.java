package br.com.gazin.desafiofullstack.service;

import br.com.gazin.desafiofullstack.dto.CadastrarDesenvolvedorDTO;
import br.com.gazin.desafiofullstack.dto.DesenvolvedorDTO;
import br.com.gazin.desafiofullstack.persistence.DesenvolvedorRepository;
import br.com.gazin.desafiofullstack.utils.DesenvolvedorMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesenvolvedorService {

    private DesenvolvedorRepository desenvolvedorRepository;

    public DesenvolvedorService(DesenvolvedorRepository desenvolvedorRepository) {
        this.desenvolvedorRepository = desenvolvedorRepository;
    }

    public List<DesenvolvedorDTO> buscarTodos() {
        var desenvolvedorList = desenvolvedorRepository.findAll();
        var dtoList = DesenvolvedorMapper.toDTOList(desenvolvedorList);
        return dtoList;
    }

    public DesenvolvedorDTO cadastrar(CadastrarDesenvolvedorDTO cadastrarDesenvolvedorDTO) {
        var desenvolvedor = DesenvolvedorMapper.toEntity(cadastrarDesenvolvedorDTO);
        desenvolvedorRepository.saveAndFlush(desenvolvedor);
        var desenvolvedorAtualizado = desenvolvedorRepository.getReferenceById(desenvolvedor.getId());
        return DesenvolvedorMapper.toDTO(desenvolvedorAtualizado);
    }

}