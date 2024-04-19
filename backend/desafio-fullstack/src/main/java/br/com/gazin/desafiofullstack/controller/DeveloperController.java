package br.com.gazin.desafiofullstack.controller;

import br.com.gazin.desafiofullstack.dto.DeveloperDTO;
import br.com.gazin.desafiofullstack.service.DeveloperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/developers")
public class DeveloperController {

    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping
    public ResponseEntity<List<DeveloperDTO>> findAll() {
        List<DeveloperDTO> dtoListResponse = developerService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(dtoListResponse);
    }

}