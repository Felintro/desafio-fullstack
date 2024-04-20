package br.com.gazin.desafiofullstack.controller;

import br.com.gazin.desafiofullstack.dto.CadastrarNivelDTO;
import br.com.gazin.desafiofullstack.dto.NivelDTO;
import br.com.gazin.desafiofullstack.service.NivelService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.PersistenceException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/niveis")
public class NivelController {

    private final NivelService nivelService;

    public NivelController(NivelService nivelService) {
        this.nivelService = nivelService;
    }

    @GetMapping
    public ResponseEntity<List<NivelDTO>> retornarTodos() {
        var dtoListResponse = nivelService.buscarTodos();
        if(dtoListResponse.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dtoListResponse);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(dtoListResponse);
        }
    }

    @PostMapping
    public ResponseEntity<NivelDTO> cadastrar(@Valid @RequestBody CadastrarNivelDTO dto) throws JsonProcessingException {
        var nivelDTO = nivelService.cadastrar(dto.nivel());
        return ResponseEntity.status(HttpStatus.CREATED).body(nivelDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarPorId(@PathVariable Integer id) {
        try {
            nivelService.deletarPorId(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nível removido com sucesso!");
        } catch(PersistenceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Existem desenvolvedores associados a este nível!");
        }
    }

}