package br.com.gazin.desafiofullstack.controller;

import br.com.gazin.desafiofullstack.dto.NivelDTO;
import br.com.gazin.desafiofullstack.service.NivelService;
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
@RequestMapping("/api/niveis")
public class NivelController {

    private final NivelService nivelService;

    public NivelController(NivelService nivelService) {
        this.nivelService = nivelService;
    }

    @GetMapping
    public ResponseEntity<List<NivelDTO>> retornarTodos() {
        var dtoListResposta = nivelService.buscarTodos();
        if(dtoListResposta.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dtoListResposta);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(dtoListResposta);
        }
    }

    @PostMapping
    public ResponseEntity<NivelDTO> cadastrar(@Valid @RequestBody NivelDTO corpoRequisicaoDTO) {
        var dtoResposta = nivelService.cadastrar(corpoRequisicaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoResposta);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable Integer id, @Valid @RequestBody NivelDTO corpoRequisicaoDTO) {
        try {
            var dtoResposta = nivelService.atualizar(id, corpoRequisicaoDTO);
            return ResponseEntity.ok().body(dtoResposta);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Integer id) {
        try {
            nivelService.deletarPorId(id);
            return ResponseEntity.noContent().build();
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}