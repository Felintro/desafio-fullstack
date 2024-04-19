package br.com.gazin.desafiofullstack.controller;

import br.com.gazin.desafiofullstack.dto.LevelDTO;
import br.com.gazin.desafiofullstack.service.LevelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/levels")
public class LevelController {

    private LevelService levelService;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @GetMapping
    public ResponseEntity<List<LevelDTO>> findAll() {
        List<LevelDTO> dtoListResponse = levelService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(dtoListResponse);
    }

}