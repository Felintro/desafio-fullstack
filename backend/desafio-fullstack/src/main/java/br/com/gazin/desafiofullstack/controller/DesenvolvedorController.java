package br.com.gazin.desafiofullstack.controller;

import br.com.gazin.desafiofullstack.dto.DesenvolvedorDTO;
import br.com.gazin.desafiofullstack.service.DesenvolvedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
        return ResponseEntity.status(HttpStatus.OK).body(dtoListResponse);
    }

}