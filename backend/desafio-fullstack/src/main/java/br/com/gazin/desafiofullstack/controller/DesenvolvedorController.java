package br.com.gazin.desafiofullstack.controller;

import br.com.gazin.desafiofullstack.dto.CadastrarDesenvolvedorDTO;
import br.com.gazin.desafiofullstack.dto.DesenvolvedorDTO;
import br.com.gazin.desafiofullstack.service.DesenvolvedorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/desenvolvedores")
public class DesenvolvedorController {

    private final DesenvolvedorService desenvolvedorService;

    public DesenvolvedorController(DesenvolvedorService desenvolvedorService) {
        this.desenvolvedorService = desenvolvedorService;
    }

    @GetMapping
    public ResponseEntity<List<DesenvolvedorDTO>> retornarTodos() {
        List<DesenvolvedorDTO> dtoListResponse = desenvolvedorService.buscarTodos();
        if(dtoListResponse.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dtoListResponse);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(dtoListResponse);
        }
    }

    @PostMapping
    public ResponseEntity<DesenvolvedorDTO> cadastrar(@Valid @RequestBody CadastrarDesenvolvedorDTO corpoRequisicaoDTO) {
        var desenvolvedorDTO = desenvolvedorService.cadastrar(corpoRequisicaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(desenvolvedorDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable Integer id, @Valid @RequestBody CadastrarDesenvolvedorDTO corpoRequisicaoDTO) {
        try {
            var dtoResposta = desenvolvedorService.atualizar(id, corpoRequisicaoDTO);
            return ResponseEntity.ok().body(dtoResposta);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Integer id) {
        try {
            desenvolvedorService.deletarPorId(id);
            return ResponseEntity.noContent().build();
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}