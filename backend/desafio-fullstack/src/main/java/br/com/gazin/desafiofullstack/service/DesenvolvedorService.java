package br.com.gazin.desafiofullstack.service;

import br.com.gazin.desafiofullstack.dto.DesenvolvedorDTO;
import br.com.gazin.desafiofullstack.model.Desenvolvedor;
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
        List<Desenvolvedor> desenvolvedorList = desenvolvedorRepository.findAll();
        List<DesenvolvedorDTO> dtoList = DesenvolvedorMapper.toDTOList(desenvolvedorList);
        return dtoList;
    }

}