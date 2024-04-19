package br.com.gazin.desafiofullstack.controller;

import br.com.gazin.desafiofullstack.dto.NivelDTO;
import br.com.gazin.desafiofullstack.service.NivelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/niveis")
public class NivelController {

    private NivelService nivelService;

    public NivelController(NivelService nivelService) {
        this.nivelService = nivelService;
    }

    @GetMapping
    public ResponseEntity<List<NivelDTO>> findAll() {
        List<NivelDTO> dtoListResponse = nivelService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(dtoListResponse);
    }

}