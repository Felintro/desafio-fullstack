package br.com.gazin.desafiofullstack.service;

import br.com.gazin.desafiofullstack.dto.CadastrarDesenvolvedorDTO;
import br.com.gazin.desafiofullstack.dto.DesenvolvedorDTO;
import br.com.gazin.desafiofullstack.persistence.DesenvolvedorRepository;
import br.com.gazin.desafiofullstack.persistence.NivelRepository;
import br.com.gazin.desafiofullstack.utils.DesenvolvedorMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesenvolvedorService {

    private static final String DESENVOLVEDOR_NAO_ENCONTRADO = "O desenvolvedor não foi encontrado! ID: ";
    private static final String NIVEL_NAO_ENCONTRADO = "O nível não foi encontrado! ID: ";

    private final DesenvolvedorRepository desenvolvedorRepository;
    private final NivelRepository nivelRepository;

    public DesenvolvedorService(DesenvolvedorRepository desenvolvedorRepository, NivelRepository nivelRepository) {
        this.desenvolvedorRepository = desenvolvedorRepository;
        this.nivelRepository = nivelRepository;
    }

    public List<DesenvolvedorDTO> buscarTodos() {
        var desenvolvedorList = desenvolvedorRepository.findAll();
        var dtoList = DesenvolvedorMapper.toDTOList(desenvolvedorList);
        return dtoList;
    }

    public DesenvolvedorDTO cadastrar(CadastrarDesenvolvedorDTO cadastrarDesenvolvedorDTO) {
        var desenvolvedor = DesenvolvedorMapper.toEntity(cadastrarDesenvolvedorDTO);
        var nivel = nivelRepository.findById(cadastrarDesenvolvedorDTO.nivelId()).get();
        desenvolvedor.setNivel(nivel);
        desenvolvedorRepository.save(desenvolvedor);
        return DesenvolvedorMapper.toDTO(desenvolvedor);
    }

    public DesenvolvedorDTO atualizar(Integer id, CadastrarDesenvolvedorDTO cadastrarDesenvolvedorDTO) {
        var desenvolvedor = desenvolvedorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(DESENVOLVEDOR_NAO_ENCONTRADO + id));
        var nivel = nivelRepository.findById(cadastrarDesenvolvedorDTO.nivelId()).orElseThrow(() -> new EntityNotFoundException(NIVEL_NAO_ENCONTRADO + cadastrarDesenvolvedorDTO.nivelId()));

        desenvolvedor.setNome(cadastrarDesenvolvedorDTO.nome());
        desenvolvedor.setHobby(cadastrarDesenvolvedorDTO.hobby());
        desenvolvedor.setIdade(cadastrarDesenvolvedorDTO.idade());
        desenvolvedor.setNivel(nivel);
        desenvolvedor.setSexo(cadastrarDesenvolvedorDTO.sexo());
        desenvolvedor.setDataNascimento(cadastrarDesenvolvedorDTO.dataNascimento());

        desenvolvedorRepository.save(desenvolvedor);
        return DesenvolvedorMapper.toDTO(desenvolvedor);
    }

    public void deletarPorId(Integer id) {
        var desenvolvedor = desenvolvedorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(DESENVOLVEDOR_NAO_ENCONTRADO + id));
        desenvolvedorRepository.delete(desenvolvedor);
    }

}